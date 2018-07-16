package com.server;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

//92727351
public class ProviderServer {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("provider.xml");
        context.start();
        //按任意键退出
        System.in.read();
    }
}
