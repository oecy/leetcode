/*
 * @lc app=leetcode.cn id=96 lang=java
 *
 * [96] 不同的二叉搜索树
 *
 * https://leetcode-cn.com/problems/unique-binary-search-trees/description/
 *
 * algorithms
 * Medium (65.22%)
 * Likes:    497
 * Dislikes: 0
 * Total Accepted:    42.1K
 * Total Submissions: 64.4K
 * Testcase Example:  '3'
 *
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 * 
 * 示例:
 * 
 * 输入: 3
 * 输出: 5
 * 解释:
 * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 * 
 * ⁠  1         3     3      2      1
 * ⁠   \       /     /      / \      \
 * ⁠    3     2     1      1   3      2
 * ⁠   /     /       \                 \
 * ⁠  2     1         2                 3
 * 
 */

// @lc code=start
class Solution {
    /**
     * 动态规划  思路如下
     * 对于有个节点的二叉搜索树，其可能的形式种类为 每一个不同元素作为根结点时的数量相加
     * 即 G(n) = f(1) + f(2)+```+f(n) G(n)为一共可能的数量  f(n)指以n为根时的数量
     * 对于f(i)而言 以i为根节点就意味着其左子树有i-1个节点 其右子树有n-i个节点
     * 那么f(i) = G(i-1) * G(n-i)
     * 所以G(n) = G(0)*G(n-1) + G(1)*G(n-2)+````+G(n-1)G(0)
     * @param n
     * @return
     */
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2 ; i <= n ; ++i)//从2开始循环一直到n
            for(int j = 1 ; j <= i ; ++j)//从1开始循环 求最新的G(n)
                dp[i] += dp[j-1] * dp[i-j];

        return dp[n];

    }
}
// @lc code=end

