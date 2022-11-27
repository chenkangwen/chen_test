package com.example.demo.commom.myHandler;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class InterceptorConfig extends WebMvcConfigurationSupport {

    //注册拦截器到系统
    @Bean
    public MySelfHandler mySelfHandler() {
        return new MySelfHandler();
    }

    //添加拦截器到spring mvc拦截器链
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //拦截所有请求路径
        registry.addInterceptor(mySelfHandler()).addPathPatterns("/*");
    }
}
