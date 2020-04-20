/*
 * @lc app=leetcode.cn id=198 lang=java
 *
 * [198] 打家劫舍
 *
 * https://leetcode-cn.com/problems/house-robber/description/
 *
 * algorithms
 * Easy (44.14%)
 * Likes:    747
 * Dislikes: 0
 * Total Accepted:    101.6K
 * Total Submissions: 229.3K
 * Testcase Example:  '[1,2,3,1]'
 *
 * 
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 * 
 * 示例 1:
 * 
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 * 偷窃到的最高金额 = 1 + 3 = 4 。
 * 
 * 示例 2:
 * 
 * 输入: [2,7,9,3,1]
 * 输出: 12
 * 解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 * 偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        //因为偷盗的金额明显和与之前是否偷盗有关尝试动态规划
        if(nums == null || nums.length == 0)//特殊情况优先处理掉
            return 0;
        if(nums.length == 1)
            return nums[0];
        if(nums.length == 2)
            return Math.max(nums[0], nums[1]);
        //对于有三家以上的情况 f(n) = max(f(n-2)+nums[n]  , f(n-1))
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);//一定要初始化位最大值而不是nums[1]的值，不用担心第三家。因为第一家最大，则f(2)为第一家的值 根据状态转移方程则1+3必然>2.如果第二家最大则判断1+3和2哪一个更大！
        for(int i = 2 ; i < len ; i++){
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
        }

        return dp[len-1];

    }
}
// @lc code=end

