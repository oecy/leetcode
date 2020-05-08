import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=572 lang=java
 *
 * [572] 另一个树的子树
 *
 * https://leetcode-cn.com/problems/subtree-of-another-tree/description/
 *
 * algorithms
 * Easy (44.09%)
 * Likes:    233
 * Dislikes: 0
 * Total Accepted:    28.6K
 * Total Submissions: 61.9K
 * Testcase Example:  '[3,4,5,1,2]\n[4,1,2]'
 *
 * 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s
 * 也可以看做它自身的一棵子树。
 * 
 * 示例 1:
 * 给定的树 s:
 * 
 * 
 * ⁠    3
 * ⁠   / \
 * ⁠  4   5
 * ⁠ / \
 * ⁠1   2
 * 
 * 
 * 给定的树 t：
 * 
 * 
 * ⁠  4 
 * ⁠ / \
 * ⁠1   2
 * 
 * 
 * 返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。
 * 
 * 示例 2:
 * 给定的树 s：
 * 
 * 
 * ⁠    3
 * ⁠   / \
 * ⁠  4   5
 * ⁠ / \
 * ⁠1   2
 * ⁠   /
 * ⁠  0
 * 
 * 
 * 给定的树 t：
 * 
 * 
 * ⁠  4
 * ⁠ / \
 * ⁠1   2
 * 
 * 
 * 返回 false。
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
class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        /**
         * 解题思路:对于s的每一个字串将之与t进行匹配
         */
        if(s == null && t == null)
            return true;

        Stack<TreeNode> stack = new Stack<>();

        stack.add(s);
        while(!stack.isEmpty()){
            TreeNode tn = stack.pop();
            if(isSame(tn, t))
                return true;
            
            if(tn.left != null)
                stack.add(tn.left);
            if(tn.right != null)
                stack.add(tn.right);

        }
        return false;
        
    }

    public boolean isSame(TreeNode s,TreeNode t){
        if(s == null && t == null)
            return  true;
        if(s == null || t == null)
            return false;
        if(s.val != t.val)
            return false;
        boolean left = isSame(s.left, t.left);
        boolean right = isSame(s.right, t.right);

        return left & right;
    }



}
// @lc code=end

