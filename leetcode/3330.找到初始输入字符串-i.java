/*
 * @lc app=leetcode.cn id=3330 lang=java
 *
 * [3330] 找到初始输入字符串 I
 */

// @lc code=start
class Solution {
    public int possibleStringCount(String word) {
        int res = 1 ;
        int prev = word.charAt(0);
        for(int i = 1 ; i < word.length() ; i++){
            if(prev == word.charAt(i)){
                res += 1;
            }else{
                prev = word.charAt(i);
            }
        }
        return res;
    }
}
// @lc code=end

