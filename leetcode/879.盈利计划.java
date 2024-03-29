/*
 * @lc app=leetcode.cn id=879 lang=java
 *
 * [879] 盈利计划
 */

// @lc code=start
class Solution {
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        // int len = group.length, MOD = (int)1e9 + 7;
        // int[][][] dp = new int[len + 1][n + 1][minProfit + 1];
        // dp[0][0][0] = 1;
        // for (int i = 1; i <= len; i++) {
        //     int members = group[i - 1], earn = profit[i - 1];
        //     for (int j = 0; j <= n; j++) {
        //         for (int k = 0; k <= minProfit; k++) {
        //             if (j < members) {
        //                 dp[i][j][k] = dp[i - 1][j][k];
        //             } else {
        //                 dp[i][j][k] = (dp[i - 1][j][k] + dp[i - 1][j - members][Math.max(0, k - earn)]) % MOD;
        //             }
        //         }
        //     }
        // }
        // int sum = 0;
        // for (int j = 0; j <= n; j++) {
        //     sum = (sum + dp[len][j][minProfit]) % MOD;
        // }
        // return sum;
        int len = group.length, Mod=(int)1e9+7;
        int[][] dp = new int[len+1][minProfit+1];
        for (int i = 0; i < len; i++) {
            int members = group[i];
            int earn = profit[i];
            for (int j = n; j >= members; j--) {
                for (int k = minProfit; k >= 0 ; k--) {
                    dp[j][k] = (dp[j][k]+dp[j-members][Math.max(0, k-earn)])% Mod;
                }
            }
        }
        return dp[n][minProfit];
    }
}
// @lc code=end

