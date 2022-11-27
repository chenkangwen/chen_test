package com.example.demo.commom.nioTest.dubboTest.service;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.lang.reflect.Proxy;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NettyClient {

    //创建线程池
    private static ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

	//clientHandler要保存起来，因为一个channel只会对应一个channelPipeline，
	//而每个channelPipeline的handler的也只有在ChannelInitializer添加一次，之后该channel会一直使用该handler
    private static NettyClientHandler clientHandler;

    //编写方法使用代理模式，获取一个代理对象	
    public Object getBean(final Class<?> serivceClass, final String providerName) {	

        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                new Class<?>[]{serivceClass}, (proxy, method, args) -> {
                    //连接是在获取bean的时候建立，不是提前建立
                    if (clientHandler == null) {
                        initClient();
                    }

                    //用保存下来的handler设置要发给服务器端的信息
                    //providerName 协议头 args[0] 就是rpc调用传递的参数，有多个参数时依次类推
                    clientHandler.setPara(providerName + args[0]);

					//必须同步阻塞等到返回
                    return executor.submit(clientHandler).get();

                });
    }

    //初始化客户端
    private static void initClient() {
        clientHandler = new NettyClientHandler();
        //创建EventLoopGroup
        NioEventLoopGroup group = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(group)
                .channel(NioSocketChannel.class)
                .option(ChannelOption.TCP_NODELAY, true)
                .handler(
                        new ChannelInitializer<SocketChannel>() {
                            @Override
                            protected void initChannel(SocketChannel ch) throws Exception {
                                ChannelPipeline pipeline = ch.pipeline();
                                pipeline.addLast(new StringDecoder());
                                pipeline.addLast(new StringEncoder());
                                pipeline.addLast(clientHandler);
                            }
                        }
                );

        try {
            ChannelFuture sync = bootstrap.connect("127.0.0.1", 7000).sync();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
