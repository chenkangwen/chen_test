package com.example.demo.commom.nioTest;


import com.alibaba.fastjson.JSON;

import javax.servlet.http.Cookie;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/***
 * 需求：使用前面学习后的 ByteBuffer(缓冲)和 FileChannel(通道)， 将数据写入到 data.txt 中.
 */
public class ChannelTest {


    public static void main(String[] args)throws Exception{
        System.out.println(JSON.toJSONString(args));
        Cookie cookie = new Cookie("HEHE","HEHE");
        read();
        //write();
    }

    /***
     * 设置两个缓冲区，一大一小，大的缓冲区为每次读取的量，小的缓冲区存放每行的数据（确保大小可存放文本中最长的那行）。读取的时候判断是不是换行符13，是的话则返回一行数据，不是的话继续读取，直到读完文件。
     * @throws Exception
     */

    public static void read() throws Exception {
        // 1、定义一个文件字节输入流与源文件接通
        FileInputStream is = new FileInputStream("D:\\test\\test.txt");
        // 2、需要得到文件字节输入流的文件通道
        FileChannel channel = is.getChannel();
        // 3、定义一个缓冲区
        int bufferSize = 1024 * 1024;  // 每一块的大小
        ByteBuffer buffer = ByteBuffer.allocate(bufferSize);

        ByteBuffer bb = ByteBuffer.allocate(1024);

        // 4、读取数据到缓冲区
        int bytesRead = channel.read(buffer);
        while (bytesRead != -1) {
            buffer.flip();// 切换模式，写->读
            while (buffer.hasRemaining()) {//返回 position 和 limit 之间的元素个数
                byte b = buffer.get();
                if (b == 10 || b == 13) { // 换行或回车
                    bb.flip();
                    // 这里就是一个行
                    final String line = Charset.forName("utf-8").decode(bb).toString();
                    System.out.println(line);// 解码已经读到的一行所对应的字节
                    bb.clear();
                } else {
                    if (bb.hasRemaining())
                        bb.put(b);
                    else { // 空间不够扩容
                        //bb = reAllocate(bb);
                        bb.put(b);
                    }
                }
            }
            buffer.clear();// 清空,position位置为0，limit=capacity
            //  继续往buffer中写
            bytesRead = channel.read(buffer);
        }
        channel.close();
    }
 

    public static void write(){
        try {
            // 1、字节输出流通向目标文件
            FileOutputStream fos = new FileOutputStream("D:\\test\\test.txt");
            // 2、得到字节输出流对应的通道Channel
            FileChannel channel = fos.getChannel();
            // 3、分配缓冲区
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            for (int i = 0; i < 10; i++) {
                buffer.clear();//清空缓冲区
                buffer.put(("hello,使用Buffer和channel实现写数据到文件中"+i+"\r\n").getBytes());
                // 4、把缓冲区切换成写出模式
                buffer.flip();
                channel.write(buffer);//将缓冲区的数据写入到文件通道
            }
            channel.close();
            System.out.println("写数据到文件中！");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}