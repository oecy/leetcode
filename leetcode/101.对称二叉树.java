/*
 * @lc app=leetcode.cn id=101 lang=java
 *
 * [101] 对称二叉树
 *
 * https://leetcode-cn.com/problems/symmetric-tree/description/
 *
 * algorithms
 * Easy (50.65%)
 * Likes:    734
 * Dislikes: 0
 * Total Accepted:    126.5K
 * Total Submissions: 248.9K
 * Testcase Example:  '[1,2,2,3,4,4,3]'
 *
 * 给定一个二叉树，检查它是否是镜像对称的。
 * 
 * 
 * 
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * 
 * ⁠   1
 * ⁠  / \
 * ⁠ 2   2
 * ⁠/ \ / \
 * 3  4 4  3
 * 
 * 
 * 
 * 
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 * 
 * ⁠   1
 * ⁠  / \
 * ⁠ 2   2
 * ⁠  \   \
 * ⁠  3    3
 * 
 * 
 * 
 * 
 * 进阶：
 * 
 * 你可以运用递归和迭代两种方法解决这个问题吗？
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();//辅助队列
        q.add(root);//根结点两次入队因为需要左右节点判断要两个
        q.add(root);
        while (!q.isEmpty()) {//当队列不为空时
            TreeNode t1 = q.poll();//得到节点
            TreeNode t2 = q.poll();//得到对称节点
            if (t1 == null && t2 == null) continue;//如果两个均为空，则继续判断
            if (t1 == null || t2 == null) return false;//如果有一个为空则必然不对称
            if (t1.val != t2.val) return false;//节点值不等不不对称
            q.add(t1.left);//左
            q.add(t2.right);//右  对称入队
            q.add(t1.right);
            q.add(t2.left);
        }
        return true;
    }
}
// @lc code=end

