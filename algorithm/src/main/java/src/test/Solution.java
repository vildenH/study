package src.test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import lombok.Data;

public class Solution {

  public static void main(String[] args) {
    BigDecimal initValue = new BigDecimal("20651.02");
    List<model> initList = Arrays.asList(
        new model("-0.83", "1037798.20"),
        new model("100000000.00", "102037798.20"),
        new model("-200.00", "20249.02"),
        new model("17551.84", "37800.03"),
        new model("100000000.00", "100020651.02"),
        new model("-200.00", "20449.02"),
        new model("1000000.00", "1037800.03"),
        new model("-100000000.00", "20651.02"),
        new model("10253333.33", "12291131.53"),
        new model("-0.83", "20248.19"),
        new model("-10253333.33", "2037798.20"),
        new model("10595111.11", "10632911.14"),
        new model("-2.00", "20649.02"),
        new model("1000000.00", "2037798.20"),
        new model("-1.00", "1037799.03"),
        new model("-10595111.11", "37800.03")
        );
    List<Integer> result = new LinkedList();
    dfsMatch(initValue, initList, result);
    for (Integer temp : result) {
      System.out.println("" + initList.get(temp).getOperation() + "," + initList.get(temp).getBalance());
    }
  }

  static void dfsMatch(BigDecimal nowValue, List<model> modelList, List<Integer> result) {
    if (result.size() == modelList.size()) {
      return;
    }
    for (int i = 0; i < modelList.size(); i++) {
      model nowOpera = modelList.get(i);
      if (!nowOpera.isUse) {
        if (nowValue.add(nowOpera.getOperation()).equals(nowOpera.getBalance())) {
          result.add(i);
          nowOpera.isUse = true;
          dfsMatch(nowOpera.getBalance(), modelList, result);
          if (result.size() == modelList.size()) {
            return;
          }
          nowOpera.isUse = false;
          result.remove(result.size()-1);
        }
      }
    }
  }
}

@Data
class model {

  BigDecimal operation;
  BigDecimal balance;
  boolean isUse;

  public model(String operation, String balance) {
    this.operation = new BigDecimal(operation);
    this.balance = new BigDecimal(balance);
  }
}
