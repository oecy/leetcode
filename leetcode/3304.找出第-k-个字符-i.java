/*
 * @lc app=leetcode.cn id=3304 lang=java
 *
 * [3304] 找出第 K 个字符 I
 */

// @lc code=start
class Solution {
    public char kthCharacter(int k) {
        // String s = "a";
        // int t = 0;
        // for(int i = 1 ; t < k ; i=i*2){
        //     StringBuilder sb = new StringBuilder();
        //     for(int j = 0 ; j < i ; j++){
        //         sb.append((char)(s.charAt(j)+1));
        //     }
        //     s = s+sb.toString();
        //     t = t+i;
        // }
   
        // return s.charAt(k-1);

        return (char) ('a' + (Integer.bitCount(k - 1) % 26));

    }
}
// @lc code=end
