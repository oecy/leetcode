/*
 * @lc app=leetcode.cn id=594 lang=java
 *
 * [594] 最长和谐子序列
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findLHS(int[] nums) {
        int res = 0;
        Map<Integer,Integer> map = new HashMap<>();

        for(Integer i : nums){
            map.put(i, map.getOrDefault(i, 0)+1);
        }

        for(Integer key : map.keySet()){
            int tmp = Math.max(map.getOrDefault(key+1, 0), map.getOrDefault(key-1, 0));
            if(tmp != 0)
                res = Math.max(res, map.get(key)+tmp);

        }


        return res;
    }
}
// @lc code=end

