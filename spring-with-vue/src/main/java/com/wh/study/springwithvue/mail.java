package com.wh.study.springwithvue;

import com.sun.mail.util.MailSSLSocketFactory;
import java.security.GeneralSecurityException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Objects;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.junit.Test;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class mail {

  private static String mailAuthCode = "mzrpmapdnjubbiha";
  // 收件人邮箱,不仅仅QQ邮箱
  private static String toMail = "jz3092@columbia.edu";

  //发件人邮箱
  private static String fromMail = "419957563@qq.com";

  // 指定发送邮件的主机为 smtp.qq.com
  private static String host = "smtp.qq.com";  //QQ 邮件服务器

  public static String defaultText = "爱你呀崽崽:)";

  public static String mailText = "昨天晚上没有说到晚安，那今天说早安吧崽崽:)";

//  @Scheduled(cron = "0 0 * * * * ")
  public void showMail() {
    System.out.println(buildBackHomeText());
  }

  @Test
  public void testText() throws GeneralSecurityException {
//    buildBackHomeText();
//    sendMail();
  }

  /**
   * ZJQ返屋企文本
   */
  public String buildBackHomeText() {
//        回国日期
    LocalDate todayDate = LocalDate.now(ZoneId.of("America/New_York"));
    StringBuilder text = new StringBuilder();
    text.append("Hi,Jennie!\n")
        .append("周嘉琪小朋友你好呀hh!\n");
    text.append(String.format("今天的日期是 %s .\n", todayDate));
    LocalDate backDate = LocalDate.of(2019, 5, 16);
    if (backDate.isAfter(todayDate)) {
      long days = backDate.toEpochDay() - todayDate.toEpochDay();
      text.append(String.format("离visiting结束 %s 只剩 【 %s 】 天啦！！ \n", backDate, days));
    }
    if (Objects.nonNull(mailText)) {
      text.append(mailText + "爱你呀:)");
    } else {
      text.append(defaultText);
    }

    LocalDateTime.now().minusDays(1);
    System.out.println(text);
    return text.toString();

  }

  @Scheduled(cron = "0 0/1 * * * * ")
  public void sendMail() throws GeneralSecurityException {
    LocalTime time = LocalTime.of(19, 7);
    if (!LocalTime.now().withSecond(0).withNano(0).equals(time)) {
      return;
    }
    //  获取系统属性
    Properties properties = System.getProperties();
    // 设置邮件服务器
    properties.setProperty("mail.smtp.host", host);
    properties.put("mail.smtp.auth", "true");
    MailSSLSocketFactory sf = new MailSSLSocketFactory();
    sf.setTrustAllHosts(true);
    properties.put("mail.smtp.ssl.enable", "true");
    properties.put("mail.smtp.ssl.socketFactory", sf);
    // 获取默认session对象
    Session session = Session.getDefaultInstance(properties, new Authenticator() {
      @Override
      public PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(fromMail, mailAuthCode); //登录邮箱及授权码
      }
    });

    try {
      // 创建默认的 MimeMessage 对象
      MimeMessage message = new MimeMessage(session);

      // Set From: 头部头字段
      message.setFrom(new InternetAddress(fromMail));

      // Set To: 头部头字段
      message.addRecipient(Message.RecipientType.TO, new InternetAddress(toMail));

      // Set Subject: 头部头字段
      message.setSubject("小朋友返屋企倒数日！");

      // 设置消息体
      message.setText(buildBackHomeText());

      // 发送消息
      Transport.send(message);
      System.out.println("Sent message successfully");
      mailText = null;
    } catch (AddressException e) {
      e.printStackTrace();
    } catch (javax.mail.MessagingException e) {
      e.printStackTrace();
    }


  }
}
