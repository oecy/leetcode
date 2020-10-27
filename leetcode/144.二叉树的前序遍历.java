import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=144 lang=java
 *
 * [144] 二叉树的前序遍历
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
    List<Integer> res = new LinkedList();
    public List<Integer> preorderTraversal(TreeNode root) {
        preOrder(root);
        return res;

    }


    public void preOrder(TreeNode root){
        if(root == null)
            return;
        res.add(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }
}
// @lc code=end

