/*
 * @lc app=leetcode.cn id=50 lang=java
 *
 * [50] Pow(x, n)
 *
 * https://leetcode-cn.com/problems/powx-n/description/
 *
 * algorithms
 * Medium (34.27%)
 * Likes:    362
 * Dislikes: 0
 * Total Accepted:    85.1K
 * Total Submissions: 240K
 * Testcase Example:  '2.00000\n10'
 *
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 * 
 * 示例 1:
 * 
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 
 * 
 * 示例 2:
 * 
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 
 * 
 * 示例 3:
 * 
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2^-2 = 1/2^2 = 1/4 = 0.25
 * 
 * 说明:
 * 
 * 
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−2^31, 2^31 − 1] 。
 * 
 * 
 */

// @lc code=start
class Solution {
    /**
     * 解题思路:二分法加递归 对于x的偶数次幂  可以理解为 x的2i次幂 = x的i次幂 * x的i次幂
     * 对于x的2i+1次幂 = x的i次幂 * x的i次幂 * x
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if(x == 0 )
            return 0.0;//返回值为double类型
        if(n == 0 || x == 1)
            return 1.0;
        
        //注意此处一定要将n转换为long 类型 因为 如果n取int的最小值 添加负号 会溢出！！！
        long N = n;
        return n > 0 ? myPow2(x, N) : 1.0/myPow2(x, -N);

    }

    public double myPow2(double x,long n){
        if(n == 0)
            return 1.0;
        double half = myPow2(x, n/2);
        if(n%2 == 0)
            return half * half;
        return half * half * x;
    }
}
// @lc code=end

