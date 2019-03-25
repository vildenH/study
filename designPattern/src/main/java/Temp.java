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


  @Test
  public void formatCebCode() throws IOException {
    ClassLoader classLoader = Temp.class.getClassLoader();
    File file = new File(classLoader.getResource("cebfile.data").getFile());
    FileInputStream input = new FileInputStream(file);
    System.out.println();
    String s = IOUtils.toString(input);
    String[] split = s.split("\n");
    System.out.println("split length" + split.length);
    for (int i = 0; i < (split.length / 6); i++) {
      for (int j = i * 6; j < i * 6 + 6; j++) {
        System.out.print(split[j] + " ");
      }
      System.out.println("\n");
    }
  }
  @Test
  public void generateCebCode() throws IOException {
    ClassLoader classLoader = Temp.class.getClassLoader();
    File file = new File(classLoader.getResource("cebfile.data").getFile());
    List<String> list = IOUtils.readLines(new FileInputStream(file));
    for (String line : list) {
      if (StringUtils.isNotBlank(line)) {
        String[] split = line.split(" ");
        System.out.printf(" %s(\"%s\", \"%s\", \"%s\", \"%s\",\"%s\")),\n", split[0], split[1], split[2],
            split[3], split[4],split[5]);
      }
    }
  }


  private static String string = "\n"
      + "    public String getTransSerial() {\n"
      + "        return transSerial;\n"
      + "    }\n"
      + "\n"
      + "    public void setTransSerial(String transSerial) {\n"
      + "        this.transSerial = transSerial;\n"
      + "    }\n"
      + "\n"
      + "    public String getBankTradeNo() {\n"
      + "        return bankTradeNo;\n"
      + "    }\n"
      + "\n"
      + "    public void setBankTradeNo(String bankTradeNo) {\n"
      + "        this.bankTradeNo = bankTradeNo;\n"
      + "    }\n"
      + "\n"
      + "    public String getProcessDateTime() {\n"
      + "        return processDateTime;\n"
      + "    }\n"
      + "\n"
      + "    public void setProcessDateTime(String processDateTime) {\n"
      + "        this.processDateTime = processDateTime;\n"
      + "    }\n"
      + "\n"
      + "    public String getBizFlag() {\n"
      + "        return bizFlag;\n"
      + "    }\n"
      + "\n"
      + "    public void setBizFlag(String bizFlag) {\n"
      + "        this.bizFlag = bizFlag;\n"
      + "    }\n"
      + "\n"
      + "    public String getBankBizNo() {\n"
      + "        return bankBizNo;\n"
      + "    }\n"
      + "\n"
      + "    public void setBankBizNo(String bankBizNo) {\n"
      + "        this.bankBizNo = bankBizNo;\n"
      + "    }\n"
      + "\n"
      + "    public String getSettlementType() {\n"
      + "        return settlementType;\n"
      + "    }\n"
      + "\n"
      + "    public void setSettlementType(String settlementType) {\n"
      + "        this.settlementType = settlementType;\n"
      + "    }\n"
      + "\n"
      + "    public boolean isPurchaseFlag() {\n"
      + "        return purchaseFlag;\n"
      + "    }\n"
      + "\n"
      + "    public void setPurchaseFlag(boolean purchaseFlag) {\n"
      + "        this.purchaseFlag = purchaseFlag;\n"
      + "    }\n"
      + "\n"
      + "    public String getOrigCurrency() {\n"
      + "        return origCurrency;\n"
      + "    }\n"
      + "\n"
      + "    public void setOrigCurrency(String origCurrency) {\n"
      + "        this.origCurrency = origCurrency;\n"
      + "    }\n"
      + "\n"
      + "    public String getOrigAmount() {\n"
      + "        return origAmount;\n"
      + "    }\n"
      + "\n"
      + "    public void setOrigAmount(String origAmount) {\n"
      + "        this.origAmount = origAmount;\n"
      + "    }\n"
      + "\n"
      + "    public String getDealCurrency() {\n"
      + "        return dealCurrency;\n"
      + "    }\n"
      + "\n"
      + "    public void setDealCurrency(String dealCurrency) {\n"
      + "        this.dealCurrency = dealCurrency;\n"
      + "    }\n"
      + "\n"
      + "    public String getDealAmount() {\n"
      + "        return dealAmount;\n"
      + "    }\n"
      + "\n"
      + "    public void setDealAmount(String dealAmount) {\n"
      + "        this.dealAmount = dealAmount;\n"
      + "    }\n"
      + "\n"
      + "    public String getSettleFlag() {\n"
      + "        return settleFlag;\n"
      + "    }\n"
      + "\n"
      + "    public void setSettleFlag(String settleFlag) {\n"
      + "        this.settleFlag = settleFlag;\n"
      + "    }\n"
      + "\n"
      + "    public String getDealRate() {\n"
      + "        return dealRate;\n"
      + "    }\n"
      + "\n"
      + "    public void setDealRate(String dealRate) {\n"
      + "        this.dealRate = dealRate;\n"
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
