package Leetcode.medium;

import java.util.Arrays;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int[] arr = new int[amount+1];
        Arrays.fill(arr,987654321);
        arr[0]=0;
        for(int i =1;i<=amount;i++){
            for(int j=0;j<coins.length;j++){
                if (coins[j] <= i) {
                    arr[i] = Math.min(arr[i],arr[i-coins[j]]+1);
                }
            }
        }
        return arr[amount]> amount ? -1:arr[amount];
    }
}
