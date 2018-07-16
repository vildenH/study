/**
 * @author wh
 * @date 2018/3/23
 */
public class Soluation {
    class Solution {
        //求一个数的开方
        public int mySqrt(int x) {
            if (x == 0) {
                return x;
            }
            int left = 0;
            int right = Integer.MAX_VALUE;
            while (true) {
                int mid = (left + right) >> 1;
                if (mid > x / mid) {
                    right = mid;
                } else {
                    if ((mid + 1) > x / (mid + 1)) {
                        return mid;
                    } else {
                        left = mid;
                    }
                }
            }
        }
    }
}
