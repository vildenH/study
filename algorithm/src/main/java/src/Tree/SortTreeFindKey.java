package src.Tree;

import java.util.Scanner;

//一颗满二叉排序树。
//深度为K，序数为1-(2^k-1)
//现在给定 k 值 和 三个节点值 。求三个节点值的最近公共节点。
//解法 利用数据结构特性，二分查找。求出共同节点。
public class SortTreeFindKey {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        System.out.println(a);
    }
}
