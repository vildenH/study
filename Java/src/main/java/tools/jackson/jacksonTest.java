package tools.jackson;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationModule;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;
import org.junit.Test;
import tools.jackson.Model.Head;

/**
 * @author wh
 * @date 2019/1/4
 */
public class jacksonTest {

  public static void main(String[] args) throws JsonProcessingException {
    ObjectMapper mapper = new XmlMapper();
    mapper.registerModule(new JaxbAnnotationModule());
    mapper.setSerializationInclusion(Include.NON_NULL);
    Model model = new Model();
    Head head = new Head();
    head.setVersion("111");
    head.setInstId("123");
    head.setTranDate("123");
    head.setTranTime("");
    model.setHead(head);
    //生成原始xml输出
    System.out.println(mapper.writer().writeValueAsString(model));
    //美化输出
    System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(model));

    //测试jaxb jackson
    JaxbModel model2 = new JaxbModel();
    model2.setVersion("123123");
    mapper.registerModule(new JaxbAnnotationModule());
    System.out.println(mapper.writer().writeValueAsString(model2));

  }

  @Test
  public void testMac()
      throws NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException {
    Mac mac = Mac.getInstance("HmacSHA256");

    byte[] keyBytes = new byte[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
    String algorithm = "3des";
    SecretKeySpec key = new SecretKeySpec(keyBytes, algorithm);

    mac.init(key);

    byte[] data = "abcdefghijklmnopqrstuvxyz".getBytes("UTF-8");
    byte[] macBytes = mac.doFinal(data);
    System.out.println(macBytes);

  }

  @Test
  public void testIndex() {
    String resp = "<out>\n"
        + "\t\t<head>\n"
        + "\t\t\t<Version>1.0.1</Version>\n"
        + "\t\t\t<InstId> 110000000000002</InstId>\n"
        + "\t\t\t<AnsTranCode>Error</AnsTranCode>\n"
        + "\t\t\t<TrmSeqNum>输入的流水号原样返回</TrmSeqNum>\n"
        + "\t\t<TranDate></TranDate>\n"
        + "\t\t<TranTime></TranTime>\n"
        + "\t\t</head>\n"
        + "<tout>\n"
        + "\t\t<errorCode>001</errorCode>\n"
        + "<errorMessage>系统交易异常</errorMessage>\n"
        + "<errorDetail>交易报文头非法，请检查交易报文头</errorDetail>\n"
        + "</tout> \n"
        + "</out>";
    String x = resp.replaceAll("\t", "");
    String s = x.replaceAll("\n", "");
    System.out.println(s);

    System.out.println(s.indexOf("<head>"));
    System.out.println(s.indexOf("</head>"));

    System.out.println(s.substring(s.indexOf("<head>"), (s.indexOf("</head>") + 7)));
  }

  @Test
  public void testGBKUTF8() throws IOException {
    System.out.println(new String("helloworld".getBytes("GBK")));
    System.out.println(new String("helloworld".getBytes("UTF-8")));
    System.out.println("------------");

    System.out.println(new String("你好".getBytes("GBK")));
    System.out.println(new String("你好".getBytes("GBK"), "GBK"));
    System.out.println(new String("你好".getBytes("UTF-8")));
    System.out.println("------------");

    File file = new File("/Users/wh/Desktop/bianma");
    FileInputStream fileInputStream = new FileInputStream(file);

    BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);

    byte[] buffer = new byte[1024];
    int length = fileInputStream.read(buffer);

    String gbkStr = new String(buffer, 0, length, "GBK");
    System.out.println(gbkStr);
    fileInputStream.close();

    System.out.println("----------");

    InputStreamReader inputStreamReader = new InputStreamReader(
        new FileInputStream(file), "GBK");
    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
    String s = bufferedReader.readLine();
    System.out.println(s);


  }
}

@Data
@JacksonXmlRootElement(localName = "in")
class Model {

  @JacksonXmlProperty(localName = "head")
  private Head head;

  @Data
  public static class Head {

    private String version;
    private String InstId;

    private String ansTranCode;
    private String trmSeqNum;
    private String tranDate;
    private String tranTime;
  }
}

@Data
@XmlRootElement(name = "JaxbmoDEL")
class JaxbModel {

  @XmlElement(name = "version")
  private String version;
}