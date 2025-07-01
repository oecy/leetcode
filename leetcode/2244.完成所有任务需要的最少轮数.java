/*
 * @lc app=leetcode.cn id=2244 lang=java
 *
 * [2244] 完成所有任务需要的最少轮数
 */

// @lc code=start

import java.util.*;

class Solution {
    public int minimumRounds(int[] tasks) {

        Map<Integer,Integer> nums = new HashMap<>();
        for(int i = 0 ; i < tasks.length ; i++){
            nums.put(tasks[i], nums.getOrDefault(tasks[i],0)+1);
        }

        Set<Integer> keys = nums.keySet();
        int res = 0;
        for(Integer key : keys){
            int count = nums.get(key);
            if(count == 1)
                return -1;
            
            int tmp = count / 3;
            int remain = count % 3;

            if(remain == 0)
                res += tmp;
            else 
                res += (tmp + 1);

        }



        return res;
    }
}
// @lc code=end

