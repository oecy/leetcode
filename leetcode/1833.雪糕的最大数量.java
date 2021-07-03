import java.util.Collections;

/*
 * @lc app=leetcode.cn id=1833 lang=java
 *
 * [1833] 雪糕的最大数量
 */

// @lc code=start
class Solution {
    /**
     * 思路：这是一道典型的动态规划题目，是一个01背包问题。限制条件就是总金额 coins。
     * 建立  dp[i] 表示当金额为i元时，可以买的最大数量
     * 初始化为dp[0] = 0;
     * 递归条件为 
     * 
     * 注意：以上思路错误，因为这一题dp会超时，因为这题要求的是可以买到的雪糕的最大的数量
     *       而不是说买一些雪糕使得这些钱刚好用完.
     */
    public int maxIceCream(int[] costs, int coins) {
        int[][] dp = new int[costs.length + 1][coins + 1];
        for (int i = 1; i <= costs.length; i++) {
            int weight = costs[i - 1];
            for (int j = 0; j <= coins; j++) {
                dp[i][j] = j >= weight ? Math.max(dp[i - 1][j - weight] + 1, dp[i - 1][j]) : dp[i - 1][j];
            }
        }
        return dp[costs.length][coins];
    }
}
// @lc code=end

