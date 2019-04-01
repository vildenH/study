package com.wh.study.springwithvue.controller;

import com.wh.study.springwithvue.mail;
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


  @RequestMapping("/setMailString")
  @ResponseBody
  public boolean setMailString(String text) {
    mail.mailText = text;
    return true;
  }

  @RequestMapping("/getMailString")
  @ResponseBody
  public String getMailString() {
    return mail.mailText;
  }

  private static int departureCountDown() {
    DateTime depatureDate = new DateTime(2019, 1, 13, 0, 0, 0);
    DateTime nowDate = DateTime.now();
    Period p = new Period(nowDate, depatureDate, PeriodType.days());
    return p.getDays();
  }

  public static void main(String[] args) {
    System.out.println(departureCountDown());

  }

  int count = 0;

  @RequestMapping("/test")
  @ResponseBody
  public int test() {
    count++;
    return count++;
//    System.out.println("test" + count);
  }


}
