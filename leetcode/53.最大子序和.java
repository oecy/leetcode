/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子序和
 *
 * https://leetcode-cn.com/problems/maximum-subarray/description/
 *
 * algorithms
 * Easy (50.01%)
 * Likes:    1831
 * Dislikes: 0
 * Total Accepted:    205.4K
 * Total Submissions: 409.2K
 * Testcase Example:  '[-2,1,-3,4,-1,2,1,-5,4]'
 *
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 
 * 示例:
 * 
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 
 * 
 * 进阶:
 * 
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 * 
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        // int res = nums[0];
        // int sum = 0;
        // for (int num : nums) {//遍历
        //     if (sum > 0)      //如果sum>0则加
        //         sum += num;
        //     else             //如果sum小于0 则说明不可能最小
        //         sum = num;
        //     res = Math.max(res, sum);
        // }
        // return res;
        int n = nums.length, maxSum = nums[0];
        for(int i = 1; i < n; ++i) {
          if (nums[i - 1] > 0) nums[i] += nums[i - 1];
          maxSum = Math.max(nums[i], maxSum);
        }
        return maxSum;
    }

}
// @lc code=end

