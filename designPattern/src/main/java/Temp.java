import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalTime;
import java.util.List;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * @author wh
 * @date 2018/7/13
 */
public class Test {

  public static void main(String[] args) throws IOException {
    for (int i = 0; i < 24; i++) {
      LocalTime beiJingTime = LocalTime.of(i, 0);
      LocalTime newYorkTime = beiJingTime.minusHours(13);
      System.out.printf("北京时间:%s  纽约时间:%s\n", beiJingTime, newYorkTime);
    }
  }

  /**
   * 生成微信网关错误码
   */
  public static void generateErrorCode() throws IOException {
    ClassLoader classLoader = Test.class.getClassLoader();
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

  String string = " public String getOrigPurchaseTransNo() {\n"
      + "        return origPurchaseTransNo;\n"
      + "    }\n"
      + "\n"
      + "    public void setOrigPurchaseTransNo(String origPurchaseTransNo) {\n"
      + "        this.origPurchaseTransNo = origPurchaseTransNo;\n"
      + "    }\n"
      + "\n"
      + "    public String getBizAgent() {\n"
      + "        return bizAgent;\n"
      + "    }\n"
      + "\n"
      + "    public void setBizAgent(String bizAgent) {\n"
      + "        this.bizAgent = bizAgent;\n"
      + "    }\n"
      + "\n"
      + "    public String getDetailsCount() {\n"
      + "        return detailsCount;\n"
      + "    }\n"
      + "\n"
      + "    public void setDetailsCount(String detailsCount) {\n"
      + "        this.detailsCount = detailsCount;\n"
      + "    }\n"
      + "\n"
      + "    public String getIsRefundBiz() {\n"
      + "        return isRefundBiz;\n"
      + "    }\n"
      + "\n"
      + "    public void setIsRefundBiz(String isRefundBiz) {\n"
      + "        this.isRefundBiz = isRefundBiz;\n"
      + "    }\n"
      + "\n"
      + "    public String getOrigRefundTrans() {\n"
      + "        return origRefundTrans;\n"
      + "    }\n"
      + "\n"
      + "    public void setOrigRefundTrans(String origRefundTrans) {\n"
      + "        this.origRefundTrans = origRefundTrans;\n"
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
      + "    public String getAmount() {\n"
      + "        return amount;\n"
      + "    }\n"
      + "\n"
      + "    public void setAmount(String amount) {\n"
      + "        this.amount = amount;\n"
      + "    }\n"
      + "\n"
      + "    public String getPayeeAgentBank() {\n"
      + "        return payeeAgentBank;\n"
      + "    }\n"
      + "\n"
      + "    public void setPayeeAgentBank(String payeeAgentBank) {\n"
      + "        this.payeeAgentBank = payeeAgentBank;\n"
      + "    }\n"
      + "\n"
      + "    public String getPayeeAgentAccount() {\n"
      + "        return payeeAgentAccount;\n"
      + "    }\n"
      + "\n"
      + "    public void setPayeeAgentAccount(String payeeAgentAccount) {\n"
      + "        this.payeeAgentAccount = payeeAgentAccount;\n"
      + "    }\n"
      + "\n"
      + "    public String getPayeeBank() {\n"
      + "        return payeeBank;\n"
      + "    }\n"
      + "\n"
      + "    public void setPayeeBank(String payeeBank) {\n"
      + "        this.payeeBank = payeeBank;\n"
      + "    }\n"
      + "\n"
      + "    public String getClearCode() {\n"
      + "        return clearCode;\n"
      + "    }\n"
      + "\n"
      + "    public void setClearCode(String clearCode) {\n"
      + "        this.clearCode = clearCode;\n"
      + "    }\n"
      + "\n"
      + "    public String getPayeeAccount() {\n"
      + "        return payeeAccount;\n"
      + "    }\n"
      + "\n"
      + "    public void setPayeeAccount(String payeeAccount) {\n"
      + "        this.payeeAccount = payeeAccount;\n"
      + "    }\n"
      + "\n"
      + "    public String getPayeeEnglishName() {\n"
      + "        return payeeEnglishName;\n"
      + "    }\n"
      + "\n"
      + "    public void setPayeeEnglishName(String payeeEnglishName) {\n"
      + "        this.payeeEnglishName = payeeEnglishName;\n"
      + "    }\n"
      + "\n"
      + "    public String getPayeeEnglishAddress() {\n"
      + "        return payeeEnglishAddress;\n"
      + "    }\n"
      + "\n"
      + "    public void setPayeeEnglishAddress(String payeeEnglishAddress) {\n"
      + "        this.payeeEnglishAddress = payeeEnglishAddress;\n"
      + "    }\n"
      + "\n"
      + "    public String getPaymentInfo() {\n"
      + "        return paymentInfo;\n"
      + "    }\n"
      + "\n"
      + "    public void setPaymentInfo(String paymentInfo) {\n"
      + "        this.paymentInfo = paymentInfo;\n"
      + "    }\n"
      + "\n"
      + "    public String getFeeType() {\n"
      + "        return FeeType;\n"
      + "    }\n"
      + "\n"
      + "    public void setFeeType(String feeType) {\n"
      + "        FeeType = feeType;\n"
      + "    }\n"
      + "\n"
      + "    public String getPostscript() {\n"
      + "        return postscript;\n"
      + "    }\n"
      + "\n"
      + "    public void setPostscript(String postscript) {\n"
      + "        this.postscript = postscript;\n"
      + "    }\n"
      + "\n"
      + "    public String getPayeeName() {\n"
      + "        return payeeName;\n"
      + "    }\n"
      + "\n"
      + "    public void setPayeeName(String payeeName) {\n"
      + "        this.payeeName = payeeName;\n"
      + "    }\n"
      + "\n"
      + "    public String getPayeeAreaCode() {\n"
      + "        return payeeAreaCode;\n"
      + "    }\n"
      + "\n"
      + "    public void setPayeeAreaCode(String payeeAreaCode) {\n"
      + "        this.payeeAreaCode = payeeAreaCode;\n"
      + "    }\n"
      + "\n"
      + "    public String getTransCode() {\n"
      + "        return transCode;\n"
      + "    }\n"
      + "\n"
      + "    public void setTransCode(String transCode) {\n"
      + "        this.transCode = transCode;\n"
      + "    }\n"
      + "\n"
      + "    public Boolean getBonded() {\n"
      + "        return isBonded;\n"
      + "    }\n"
      + "\n"
      + "    public void setBonded(Boolean bonded) {\n"
      + "        isBonded = bonded;\n"
      + "    }\n"
      + "\n"
      + "    public List<CebReportDetailsModel> getCebReportDetailsModelList() {\n"
      + "        return cebReportDetailsModelList;\n"
      + "    }\n"
      + "\n"
      + "    public void setCebReportDetailsModelList(List<CebReportDetailsModel> cebReportDetailsModelList) {\n"
      + "        this.cebReportDetailsModelList = cebReportDetailsModelList;\n"
      + "    }\n"
      + "\n"
      + "    public String getOrigPurchaseDate() {\n"
      + "        return origPurchaseDate;\n"
      + "    }\n"
      + "\n"
      + "    public void setOrigPurchaseDate(String origPurchaseDate) {\n"
      + "        this.origPurchaseDate = origPurchaseDate;\n"
      + "    }\n"
      + "\n"
      + "    public String getServiceType() {\n"
      + "        return serviceType;\n"
      + "    }\n"
      + "\n"
      + "    public void setServiceType(String serviceType) {\n"
      + "        this.serviceType = serviceType;\n"
      + "    }";

  public static void generateThriftAnno() {
    StringBuilder result = new StringBuilder();

  }
}
