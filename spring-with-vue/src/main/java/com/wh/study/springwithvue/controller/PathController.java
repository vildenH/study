package com.wh.study.springwithvue.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PathController {
    @RequestMapping("/")
    @ResponseBody
    public String index() {
        return "周嘉琪是傻瓜";
    }

}
