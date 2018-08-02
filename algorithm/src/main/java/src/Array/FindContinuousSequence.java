package src.Array;

//小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
// 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
// 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
// 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列?

//输出描述:
//输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序

import java.util.ArrayList;

public class FindContinuousSequence {

    public int getSum(int start, int end) {
        int Sum = ((start + end) * (end - start + 1)) / 2;
        return Sum;
    }


    public ArrayList<ArrayList<Integer>> findContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        int start = 1;
        for (int end = 1; end < sum; ) {
            int nowSum = getSum(start, end);
            if (nowSum < sum) {
                end++;
            } else if (nowSum == sum) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = start; i <= end; i++) {
                    list.add(i);
                }
                ans.add(list);
                end++;
            } else if (nowSum > sum) {
                start++;
            }

        }

        return ans;
    }

    public static void main(String[] args) {
        new FindContinuousSequence().findContinuousSequence(3);

    }
}