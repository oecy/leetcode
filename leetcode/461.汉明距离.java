/*
 * @lc app=leetcode.cn id=461 lang=java
 *
 * [461] 汉明距离
 */

// @lc code=start
class Solution {
    public int hammingDistance(int x, int y) {
        /**
         * 基本思路对于每一位的不同可以将x和y不断的对2取余。相当于右移1位
         * 如果同则余数相同，如果不同则余数不同 count++
         * 然后将xy分别除以2 完成右移
         */
        int count = 0;
        while(x != 0 || y != 0 ){
            if((x%2) != (y%2)){
                count++;
            }
            x = x/2;
            y= y/2;
        }
        return count;
    }
}
// @lc code=end

