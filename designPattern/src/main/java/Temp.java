import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalTime;
import java.util.List;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

/**
 * @author wh
 * @date 2018/7/13
 */
public class Temp {

  public static void main(String[] args) throws IOException {

  }

  /**
   * 纽约时间和北京时间对比
   */
  @Test
  public void generateNewYorkTime() {
    for (int i = 0; i < 24; i++) {
      LocalTime beiJingTime = LocalTime.of(i, 0);
      LocalTime newYorkTime = beiJingTime.minusHours(13);
      System.out.printf("北京时间:%s  纽约时间:%s\n", beiJingTime, newYorkTime);
    }
  }

  /**
   * 生成微信网关错误码
   */
  @Test
  public void generateErrorCode() throws IOException {
    ClassLoader classLoader = Temp.class.getClassLoader();
    File file = new File(classLoader.getResource("errorCode.data").getFile());
    List<String> list = IOUtils.readLines(new FileInputStream(file));
    // for (String line : list) {
    //     System.out.println(line);
    // }
    for (String line : list) {
      if (StringUtils.isNotBlank(line)) {
        String[] split = line.split(" ");
        System.out.printf(" %s(\"%s\", \"%s\", \"%s\", \"%s\"),\n", split[0], split[0], split[1],
            split[2], split[3]);
      }
    }
  }

  private static String string = "public String getBizType() {\n"
      + "        return bizType;\n"
      + "    }\n"
      + "\n"
      + "    public void setBizType(String bizType) {\n"
      + "        this.bizType = bizType;\n"
      + "    }\n"
      + "\n"
      + "    public String getCurrency() {\n"
      + "        return currency;\n"
      + "    }\n"
      + "\n"
      + "    public void setCurrency(String currency) {\n"
      + "        this.currency = currency;\n"
      + "    }\n"
      + "\n"
      + "    public String getPurpose() {\n"
      + "        return purpose;\n"
      + "    }\n"
      + "\n"
      + "    public void setPurpose(String purpose) {\n"
      + "        this.purpose = purpose;\n"
      + "    }\n"
      + "\n"
      + "    public String getDetailsSerial() {\n"
      + "        return detailsSerial;\n"
      + "    }\n"
      + "\n"
      + "    public void setDetailsSerial(String detailsSerial) {\n"
      + "        this.detailsSerial = detailsSerial;\n"
      + "    }\n"
      + "\n"
      + "    public String getServiceType() {\n"
      + "        return serviceType;\n"
      + "    }\n"
      + "\n"
      + "    public void setServiceType(String serviceType) {\n"
      + "        this.serviceType = serviceType;\n"
      + "    }\n"
      + "\n"
      + "    public String getDetailsAmount() {\n"
      + "        return detailsAmount;\n"
      + "    }\n"
      + "\n"
      + "    public void setDetailsAmount(String detailsAmount) {\n"
      + "        this.detailsAmount = detailsAmount;\n"
      + "    }\n"
      + "\n"
      + "    public Boolean getDetailsRefund() {\n"
      + "        return isDetailsRefund;\n"
      + "    }\n"
      + "\n"
      + "    public void setDetailsRefund(Boolean detailsRefund) {\n"
      + "        isDetailsRefund = detailsRefund;\n"
      + "    }\n"
      + "\n"
      + "    public String getOrigTransNo() {\n"
      + "        return origTransNo;\n"
      + "    }\n"
      + "\n"
      + "    public void setOrigTransNo(String origTransNo) {\n"
      + "        this.origTransNo = origTransNo;\n"
      + "    }\n"
      + "\n"
      + "    public String getTradeNo() {\n"
      + "        return tradeNo;\n"
      + "    }\n"
      + "\n"
      + "    public void setTradeNo(String tradeNo) {\n"
      + "        this.tradeNo = tradeNo;\n"
      + "    }";

  @Test
  public void generateThriftAnno() {
    StringBuilder result = new StringBuilder();
    String[] strs = string.split("\n");
    int fieldCount = 1;
    for (String str : strs) {
      if (str.indexOf("get") > 0) {
        result.append(String.format("@ThriftField(%s)", fieldCount));
        fieldCount++;
      } else if (str.indexOf("set") > 0) {
        result.append("@ThriftField");
      }
      result.append(str);

    }
    System.out.println(result.toString());
  }
}
