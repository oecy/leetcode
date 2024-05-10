/*
 * @lc app=leetcode.cn id=2960 lang=java
 *
 * [2960] 统计已测试设备
 */

// @lc code=start
class Solution {
    public int countTestedDevices(int[] batteryPercentages) {
        

        int res = 0;
        //需要扣除的电量，每测试一次加1
        int last = 0;
        for (int i = 0 ; i < batteryPercentages.length; i++) {
            if(batteryPercentages[i] > last){
                res++;
                last++;
            }
        }

        return res;
    }
}
// @lc code=end

