import com.sun.mail.util.MailSSLSocketFactory;
import java.security.GeneralSecurityException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class mail {

  private static String mailAuthCode = "mzrpmapdnjubbiha";
  // 收件人邮箱,不仅仅QQ邮箱
  private static String toMail = "jz3092@columbia.edu";

  //发件人邮箱
  private static String fromMail = "419957563@qq.com";

  // 指定发送邮件的主机为 smtp.qq.com
  private static String host = "smtp.qq.com";  //QQ 邮件服务器

  public static void main(String[] args) throws GeneralSecurityException {
//    buildBackHomeText();
    sendMail();
  }

  /**
   * ZJQ返屋企文本
   */
  public static String buildBackHomeText() {
//        春假回国日期
    LocalDate springFestivalDate = LocalDate.of(2019, 3, 13);
//        回国日期
    LocalDate backDate = LocalDate.of(2019, 5, 17);

    LocalDate todayDate = LocalDate.now(ZoneId.of("America/New_York"));

    StringBuilder text = new StringBuilder();
    text.append("Hi,Jennie!\n")
        .append("周嘉琪小朋友你好呀hh!\n");
    text.append(String.format("今天的日期是 %s .\n", todayDate));
    if (springFestivalDate.isAfter(todayDate)) {
      long days = springFestivalDate.toEpochDay() - todayDate.toEpochDay();
      text.append(
          String
              .format("离春假 %s 回国只剩 【 %s 】 天啦！！:) \n", springFestivalDate, days));
    }
//        if(springFestivalDate.isEqual(todayDate)){
//            text.append(String.format("春假今天开始啦！！假期玩的开心呀！！"));
//        }
    if (backDate.isAfter(todayDate)) {
      long days = backDate.toEpochDay() - todayDate.toEpochDay();
      text.append(String.format("而且离visiting结束 %s 只剩 【 %s 】 天啦！！ \n", backDate, days));
    }
    text.append("睡前邮件，最后一天啦，马上可以抱抱我的小宝贝了！爱你呀:)");

    System.out.println("send mail text : \n" + text);
    LocalDateTime.now().minusDays(1);
    return text.toString();

  }

  public static void sendMail() throws GeneralSecurityException {
// 获取系统属性
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
    } catch (AddressException e) {
      e.printStackTrace();
    } catch (javax.mail.MessagingException e) {
      e.printStackTrace();
    }


  }
}
