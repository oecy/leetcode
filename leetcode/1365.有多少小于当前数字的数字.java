/*
 * @lc app=leetcode.cn id=1365 lang=java
 *
 * [1365] 有多少小于当前数字的数字
 */

// @lc code=start

/**
 * 思路： 基础思路  两个loop
 */
class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int length = nums.length;
        //
        int[] res = new int[length];

        //
        
        for (int i = 0; i < length; i++) {
            int cur = 0;
            for(int j = 0 ; j < length ; j++){
                if(nums[j] < nums[i])
                    cur++;
                if(j == length-1)
                    res[i] = cur;
            }
        }
        return res;
    }
}
// @lc code=end

