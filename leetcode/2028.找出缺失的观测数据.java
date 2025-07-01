/*
 * @lc app=leetcode.cn id=2028 lang=java
 *
 * [2028] 找出缺失的观测数据
 */

// @lc code=start
class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int[] res = new int[n];

        int cur = 0;
        for(int i = 0 ; i < rolls.length ; i++){
            cur += rolls[i];
        }

        int total = mean *  ( n + rolls.length);
        if(total - cur < n || total - cur > n * 6 ){
            return res;
        }
        int remain = total - cur;
        while(remain > 0){
            for(int i = 0 ; i < 6 ; i++){
                if(remain == 0){
                    return res;
                }
                remain--;
                res[i]++;
                
                
            }
        }
        return res;
    }
}
// @lc code=end

