package src.Tree;

//二叉搜索树的后序遍历序列
//输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
public class VerifySquenceOfBST {
    public boolean verify(int[] sequence, int start, int end) {
        if (start >= end) {
            return true;
        }
        int key = sequence[end];
        int i = start;
        for (; i < end; i++) {
            if (sequence[i] > sequence[end]) break;
        }
        for (int j = i; j < end; j++) {
            if (sequence[j] < sequence[end]) return false;
        }

        return verify(sequence, start, i - 1) && verify(sequence, i, end - 1);


    }

    public boolean verifySquenceOfBST(int[] sequence) {
        if (sequence.length == 0) return false;

        return verify(sequence, 0, sequence.length - 1);
    }
}
