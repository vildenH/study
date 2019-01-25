package com.wh.study.springwithvue.controller;

import org.joda.time.DateTime;
import org.joda.time.Period;
import org.joda.time.PeriodType;
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


    private static int departureCountDown() {
        DateTime depatureDate = new DateTime(2019, 1, 13, 0, 0, 0);
        DateTime nowDate = DateTime.now();
        Period p = new Period(nowDate, depatureDate,PeriodType.days());
        return p.getDays();
    }

    public static void main(String[] args) {
        System.out.println(departureCountDown());

    }


}
