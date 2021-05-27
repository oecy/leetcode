/*
 * @lc app=leetcode.cn id=664 lang=java
 *
 * [664] 奇怪的打印机
 */

// @lc code=start
class Solution {
    public int strangePrinter(String s) {
        int len = s.length();
        /**
         * 思路 从左到右依次遍历
         * dp[i]为到i为止的元素其最少的打印次数
         * 如果前一个字母和当前字母相同 那么dp[i] = dp[i-1]
         * 如果不相同 dp[i] = min{dp[i-1]+1,dp}
         * 
         * 
         * dp的思路是对的，但状态转移方程不对。且需要二维dp数组
         */
        int[][] dp = new int[len][len];
        for (int i = len - 1 ; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i+1; j < len ; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i][j - 1];
                } else {
                    int minn = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        minn = Math.min(minn, dp[i][k] + dp[k + 1][j]);
                    }
                    dp[i][j] = minn;
                }
            }
            
        }
        return dp[0][len - 1];
    }
}
// @lc code=end

