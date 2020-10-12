/*
 * @lc app=leetcode.cn id=100 lang=java
 *
 * [100] 相同的树
 *
 * https://leetcode-cn.com/problems/same-tree/description/
 *
 * algorithms
 * Easy (60.19%)
 * Likes:    486
 * Dislikes: 0
 * Total Accepted:    147.1K
 * Total Submissions: 244.3K
 * Testcase Example:  '[1,2,3]\n[1,2,3]'
 *
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 * 
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * 
 * 示例 1:
 * 
 * 输入:       1         1
 * ⁠         / \       / \
 * ⁠        2   3     2   3
 * 
 * ⁠       [1,2,3],   [1,2,3]
 * 
 * 输出: true
 * 
 * 示例 2:
 * 
 * 输入:      1          1
 * ⁠         /           \
 * ⁠        2             2
 * 
 * ⁠       [1,2],     [1,null,2]
 * 
 * 输出: false
 * 
 * 
 * 示例 3:
 * 
 * 输入:       1         1
 * ⁠         / \       / \
 * ⁠        2   1     1   2
 * 
 * ⁠       [1,2,1],   [1,1,2]
 * 
 * 输出: false
 * 
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

 /**
  * 解题思路：不断遍历两个树比较对应节点是否相等
  */
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //如果左右节点都为空则返回true
        if(p == null && q == null)
            return true;
        //两节点值不同，或者一者为空则返回false 
        //注意这里一点要先判断是否为空 先判断值是否相等有可能会出现空指针异常
        if((q == null && p != null) || (p == null && q != null) || p.val != q.val){
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
// @lc code=end

