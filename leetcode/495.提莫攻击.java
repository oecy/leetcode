/*
 * @lc app=leetcode.cn id=495 lang=java
 *
 * [495] 提莫攻击
 */

// @lc code=start
class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int res = 0;
        int last = -1;
        for(int i = 0 ; i < timeSeries.length ; i++){
            if(timeSeries[i] > last){
                res += duration;
                
            }else{
                res += timeSeries[i] + duration -last -1 ;
            }
            last = timeSeries[i] + duration - 1;
                
        }

        return res;
    }
}
// @lc code=end

