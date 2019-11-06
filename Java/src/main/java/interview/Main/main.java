package interview.Main;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.RandomUtils;

public class main {

  public static void main(String[] args) throws InterruptedException {
    int[] nums = {1, 1, 2};
    System.out.println(new main().searchRange(nums, 1));
  }

  public int[] searchRange(int[] nums, int target) {
    int i = 0, j = nums.length - 1;
    int index = -1;
    while (i <= j) {
      int mid = (i + j) / 2;
      if (nums[mid] == target) {
        index = mid;
        break;
      } else if (nums[mid] > target) {
        j = mid - 1;
      } else {
        i = mid + 1;
      }
    }
    if (index == -1) {
      return new int[]{-1, -1};
    }
    int[] result = new int[2];
    // find left
    for (int n = index; n >= 0; n--) {
      if (nums[n] == target) {
        result[0] = n;
      } else {
        break;
      }
    }
    // find right

    for (int n = index; n < nums.length; n++) {
      if (nums[n] == target) {
        result[1] = n;
      } else {
        break;
      }
    }

    return result;
  }

  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int[] total = new int[nums1.length + nums2.length];
    int i = 0;
    int j = 0;
    int n = 0;
    while (i < nums1.length && j < nums2.length) {
      if (nums1[i] < nums2[j]) {
        total[n] = nums1[i];
        i++;
        n++;
      } else {
        total[n] = nums2[j];
        j++;
        n++;
      }
    }
    while (i < nums1.length) {
      total[n] = nums1[i];
      n++;
      i++;
    }
    while (j < nums2.length) {
      total[n] = nums2[j];
      n++;
      j++;
    }
    if (total.length % 2 == 0) {
      return (total[total.length / 2] + total[total.length / 2 - 1]) / 2.0;
    } else {
      return total[total.length / 2];
    }
  }

  public static void testPoolExecutor() {
    BlockingQueue<Runnable> workQueue = new LinkedBlockingDeque<Runnable>();
    ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(5, 5, 60, TimeUnit.SECONDS,
        workQueue);
    for (int i = 0; i < 10; i++) {
      Thread a = new Thread(new Runnable() {
        @Override
        public void run() {

          System.out.println("xxxxxxxx");
        }
      });
      a.setName("111");
      System.out.println("xxx" + a.getId() + a.getName());
      poolExecutor.execute(a);
    }
    ;
  }

  public static void mtkl2Pi() {

    long count = 0;
    for (long time = 10000L; time < 100000000000L; time = time * 10) {
      System.out.println("time = " + time);
      for (int i = 0; i < time; i++) {
        double x = RandomUtils.nextDouble(0, 2) - 1;
        double y = RandomUtils.nextDouble(0, 2) - 1;
        if (((x * x) + (y * y)) <= 1) {
          count++;
        }

      }
      System.out.println(count * 4 / (time * 1.0));
      count = 0;
    }
  }
}
