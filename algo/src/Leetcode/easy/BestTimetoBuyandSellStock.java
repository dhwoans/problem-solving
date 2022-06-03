package Leetcode.easy;

public class BestTimetoBuyandSellStock {
    public int maxProfit(int[] prices) {
        int buy =Integer.MAX_VALUE;
        int answer = 0;
        for (int price : prices) {
            if (price < buy) {
                buy = price;
            } else if (price - buy > answer) {
                answer = price - buy;
            }
        }

        return answer;
    }
}
