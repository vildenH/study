package src.test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import org.apache.commons.lang3.RandomUtils;

public class MapTest {

  public static void main(String[] args) throws InterruptedException {
    HashMap<String, List<String>> map = new HashMap<>();
    String opsNode = "corp=meituan&owt=inf&pdl=kms&srv=pangolin&cluster=dev";
    String ip = "10.2.1.1";
    for (int i = 0; i < 10000; i++) {
      LinkedList<String> ips = new LinkedList<>();
      for (int j = 0; j < RandomUtils.nextInt(5, 65); j++) {
        ips.add(ip + j);
      }
      map.put(opsNode + i, ips);
    }

    while (true) {
      Thread.sleep(1000);
    }
  }
}
