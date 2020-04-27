import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=111 lang=java
 *
 * [111] 二叉树的最小深度
 *
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/description/
 *
 * algorithms
 * Easy (41.92%)
 * Likes:    245
 * Dislikes: 0
 * Total Accepted:    69.2K
 * Total Submissions: 164.2K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * 给定一个二叉树，找出其最小深度。
 * 
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 
 * 说明: 叶子节点是指没有子节点的节点。
 * 
 * 示例:
 * 
 * 给定二叉树 [3,9,20,null,null,15,7],
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 返回它的最小深度  2.
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
    public int minDepth(TreeNode root) {
        if(root == null)//特殊情况优先处理掉
            return 0;
        int depth = 0;//深度
        Queue<Pair<TreeNode,Integer>> q = new LinkedList<>();//辅助队列  使用BFS算法

        q.add(new Pair(root,1));//求深度等最好使用Pair这种结构 因为可以同时存节点和深度
        while(!q.isEmpty()){
            Pair<TreeNode, Integer> cur = q.poll();//取节点
            TreeNode t = cur.getKey();
            depth = cur.getValue();//当前的深度
            if(t.left == null && t.right == null)//遇到叶子节点说明必为最小深度直接结束
                break;
            if(t.left != null)//左孩子不为空 那么入队并且将深度加1
                q.add(new Pair(t.left,depth+1));
            if(t.right != null)
                q.add(new Pair(t.right,depth+1));
            
        }
        return depth;

    }
}
// @lc code=end

