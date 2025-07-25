/*
 * @lc app=leetcode.cn id=1695 lang=java
 *
 * [1695] 删除子数组的最大得分
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;
//[187,470,25,436,538,809,441,167,477,110,275,133,666,345,411,459,490,266,987,965,429,166,809,340,467,318,125,165,809,610,31,585,970,306,42,189,169,743,78,810,70,382,367,490,787,670,476,278,775,673,299,19,893,817,971,458,409,886,434]
class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int res = 0;
        int tmp = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ,j=0; i < nums.length ; i++){
            tmp += nums[i];
            while(map.containsKey(nums[i])){
                map.remove(nums[j]);
                tmp-=nums[j];
                j++;
            }
            map.put(nums[i], i);
            res = Math.max(tmp, res);
        }
        return res;
    }
}
// @lc code=end

