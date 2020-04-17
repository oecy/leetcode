import java.util.Stack;

/*
 * @lc app=leetcode.cn id=9 lang=java
 *
 * [9] 回文数
 *
 * https://leetcode-cn.com/problems/palindrome-number/description/
 *
 * algorithms
 * Easy (57.28%)
 * Likes:    1007
 * Dislikes: 0
 * Total Accepted:    298.9K
 * Total Submissions: 521.3K
 * Testcase Example:  '121'
 *
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 
 * 示例 1:
 * 
 * 输入: 121
 * 输出: true
 * 
 * 
 * 示例 2:
 * 
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 
 * 
 * 示例 3:
 * 
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * 
 * 
 * 进阶:
 * 
 * 你能不将整数转为字符串来解决这个问题吗？
 * 
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(int x) {
        //如果为负数必然不是回文数
        if( x < 0 )
            return false;
        if( x == 0 )
            return true;
        //计算x的反转值  比较是否相等  这是没有考虑反转溢出的情况
        int temp = x;
        int cur = 0;
        while( temp != 0){
            cur = cur * 10 + temp % 10 ;
            temp = temp / 10;
        }
        return x == cur;
 }
}
// @lc code=end

