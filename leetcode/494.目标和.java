/*
 * @lc app=leetcode.cn id=494 lang=java
 *
 * [494] 目标和
 */

// @lc code=start
class Solution {
    public int count = 0;
    public int findTargetSumWays(int[] nums, int target) {
        /**
         * 回溯法：
         * 因为每个数都可能有正负两种可能性，所以通过回溯法计算所有可能
         */
        backtrace(nums, target, 0, 0);
        return count;
    }

    public void backtrace(int[] nums,int target,int index,int sum){
        
        if(index == nums.length){
            if(sum == target){
                count++;
            }
        }else{
            backtrace(nums, target, index+1, sum+nums[index]);
            backtrace(nums, target, index+1, sum-nums[index]);
        }
    }
}
// @lc code=end

