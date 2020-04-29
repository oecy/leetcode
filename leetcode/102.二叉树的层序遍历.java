import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=102 lang=java
 *
 * [102] 二叉树的层序遍历
 *
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/description/
 *
 * algorithms
 * Medium (61.37%)
 * Likes:    458
 * Dislikes: 0
 * Total Accepted:    109.6K
 * Total Submissions: 177.8K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 * 
 * 
 * 
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 
 * 返回其层次遍历结果：
 * 
 * [
 * ⁠ [3],
 * ⁠ [9,20],
 * ⁠ [15,7]
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new LinkedList<>();//答案队列
        Queue<TreeNode> q = new LinkedList<>();//辅助队列
        if( root == null)//特殊情况处理
            return lists;
        q.add(root);//根节点入队
        while(!q.isEmpty()){
            List<Integer> list = new LinkedList<>();//临时队列处理当前层的所有val值
            int size = q.size();//当前层次的节点数
            for(int i = 0 ; i < size ; ++i){
                TreeNode t = q.poll();
                list.add(t.val);
                if(t.left != null)
                    q.add(t.left);
                if(t.right != null)
                    q.add(t.right);
            }
            lists.add(list);
        }
        return lists;

    }
}
// @lc code=end

