/*
 * @lc app=leetcode.cn id=7 lang=java
 *
 * [7] 整数反转
 *
 * https://leetcode-cn.com/problems/reverse-integer/description/
 *
 * algorithms
 * Easy (33.96%)
 * Likes:    1825
 * Dislikes: 0
 * Total Accepted:    328.5K
 * Total Submissions: 965.7K
 * Testcase Example:  '123'
 *
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 
 * 示例 1:
 * 
 * 输入: 123
 * 输出: 321
 * 
 * 
 * 示例 2:
 * 
 * 输入: -123
 * 输出: -321
 * 
 * 
 * 示例 3:
 * 
 * 输入: 120
 * 输出: 21
 * 
 * 
 * 注意:
 * 
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回
 * 0。
 * 
 */

// @lc code=start
class Solution {
    public int reverse(int x) {
        int rev = 0;//结果
		 while(x!=0)
		 {
			 if (rev != 0 && Integer.MAX_VALUE / rev < 10
	                   && Integer.MAX_VALUE / rev > -10)//溢出判断
	               return 0;
			 rev = rev*10 + x%10;
			 x = x/10;
		 }
		 
		 return rev;

    }
}
// @lc code=end

