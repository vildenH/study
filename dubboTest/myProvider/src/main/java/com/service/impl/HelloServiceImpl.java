package com.service.impl;

import com.service.HelloService;

public class HelloServiceImpl implements HelloService {
    @Override
    public String speakHello(String name) {
        return "你好：" + name;
    }
}
