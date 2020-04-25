import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=107 lang=java
 *
 * [107] 二叉树的层次遍历 II
 *
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/description/
 *
 * algorithms
 * Easy (64.72%)
 * Likes:    226
 * Dislikes: 0
 * Total Accepted:    53.7K
 * Total Submissions: 82.6K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * 
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 
 * 返回其自底向上的层次遍历为：
 * 
 * [
 * ⁠ [15,7],
 * ⁠ [9,20],
 * ⁠ [3]
 * ]
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new LinkedList<>();//结果list
        //之所以特殊处理放在list之后是因为返回值要求是 []不可以返回null
        if(root == null)
            return list;//如果为空 返回空

        
        Queue<TreeNode> q = new LinkedList<>();//辅助队列  层次队列
        Stack<List<Integer>> s = new Stack<>();//辅助栈    因为要求逆序输出所以用一下
        
        q.add(root);//根节点入队
        while(!q.isEmpty()){
            //辅助队列不为空时
            int size = q.size();//当前层的节点数
            List<Integer> temp = new LinkedList<>();//临时list
            for(int i = 0; i < size ; ++i){
                TreeNode t = q.poll();
                temp.add(t.val);
                if(t.left != null ){
                    q.add(t.left);
                }
                if(t.right != null){
                    q.add(t.right);
                }
            }
            s.add(temp);
            //temp.clear();
        }
        while(!s.isEmpty()){
            list.add(s.pop());
        }
        return list;

    }
}
// @lc code=end

