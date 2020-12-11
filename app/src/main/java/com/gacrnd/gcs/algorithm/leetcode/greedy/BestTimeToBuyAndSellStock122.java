package com.gacrnd.gcs.algorithm.leetcode.greedy;

/**
 * @author Jack_Ou  created on 2020/12/11.
 */
public class BestTimeToBuyAndSellStock122 {

    public static int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            profit += Math.max(0, prices[i] - prices[i - 1]);
        }
        return profit;
    }
}