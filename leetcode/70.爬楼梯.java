/*
 * @lc app=leetcode.cn id=70 lang=java
 *
 * [70] 爬楼梯
 *
 * https://leetcode-cn.com/problems/climbing-stairs/description/
 *
 * algorithms
 * Easy (48.19%)
 * Likes:    943
 * Dislikes: 0
 * Total Accepted:    173.6K
 * Total Submissions: 359.4K
 * Testcase Example:  '2'
 *
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 
 * 注意：给定 n 是一个正整数。
 * 
 * 示例 1：
 * 
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 
 * 示例 2：
 * 
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 * 
 * 
 */

// @lc code=start
class Solution {
    public int climbStairs(int n) {
        //动态规划   或者递归（但是看了评论递归会超时）
        //第n格可以有的方法为f(n) = f(n-1) + f(n-2)
        //其中f(n-1)是登上倒数第一阶之后再上一个格子就可以登顶
        //f(n-2)是倒数第二阶梯之后直接上2阶
        if( n ==1 )
            return 1;
        if( n==2 )
            return 2;
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for( int i = 2 ; i < n ; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n-1];
        //优化的方式   其实不需要定义dp数组。只需要定义两个变量
        /**
         *  int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
         */

    }
}
// @lc code=end

