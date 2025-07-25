/*
 * @lc app=leetcode.cn id=3487 lang=java
 *
 * [3487] 删除后的最大子数组元素和
 */

// @lc code=start

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int maxSum(int[] nums) {
        Arrays.sort(nums);
        int res =  nums[nums.length-1];
        Set<Integer> set = new HashSet<>();
        set.add( nums[nums.length-1]);
        for(int i = nums.length -2 ; i >= 0 ; i--){
            if(nums[i]<=0)
                break;
            if(set.contains(nums[i])){
                continue;
            }else{
                res+=nums[i];
                set.add(nums[i]);
            }
            
        }
        return res;
    }
}
// @lc code=end

