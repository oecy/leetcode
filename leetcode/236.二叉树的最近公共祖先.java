/*
 * @lc app=leetcode.cn id=236 lang=java
 *
 * [236] 二叉树的最近公共祖先
 *
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/description/
 *
 * algorithms
 * Medium (61.11%)
 * Likes:    514
 * Dislikes: 0
 * Total Accepted:    71.7K
 * Total Submissions: 114.3K
 * Testcase Example:  '[3,5,1,6,2,0,8,null,null,7,4]\n5\n1'
 *
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x
 * 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * 
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 * 
 * 
 * 
 * 
 * 
 * 示例 1:
 * 
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 * 
 * 
 * 示例 2:
 * 
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 * 
 * 
 * 
 * 
 * 说明:
 * 
 * 
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉树中。
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
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    //所有的递归返回值有四种可能 null,p,q,公共先祖
    //题目已经说了 pq必定存在与二叉树中
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)//遍历到叶子节点返回
            return root;
        
        if(root == p || root == q )//如果当前的节点是p或q则返回p或q
            return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);//保存返回的节点
        TreeNode right = lowestCommonAncestor(root.right, p, q);//保存返回的节点

        if(left != null && right != null)
            return root;//如果左右都存在，说明pq都出现过了，那么这就是公共祖先
        else 
            if(left !=  null)//如果左不为空那么说明pq都在左边
                return left;
            else if(right != null)//如果右不为空则说明pq都在右边
                return right;

        return null;
        
    }
}
// @lc code=end

