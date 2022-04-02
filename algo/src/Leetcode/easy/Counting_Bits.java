package Leetcode.easy;

public class Counting_Bits {
    public int[] countBits(int n) {
        int[] arr= new int[n+1];
        for (int i = 0; i <= n; i++) {
            arr[i]=Integer.bitCount(i);
        }
        return arr;
    }
}
