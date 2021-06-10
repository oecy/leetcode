/*
 * @lc app=leetcode.cn id=518 lang=java
 *
 * [518] 零钱兑换 II
 */

// @lc code=start
/**
 * 解题思路： 这种题目类似于完全01背包问题，即每个物品数量不做限制
 */
class Solution {
    public int change(int amount, int[] coins) {

        // 动态规划
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = 0; i + coin <= amount; i++) {
                dp[i + coin] += dp[i];
            }
        }
        return dp[amount];

    }
}
// @lc code=end

