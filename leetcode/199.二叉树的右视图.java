import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=199 lang=java
 *
 * [199] 二叉树的右视图
 *
 * https://leetcode-cn.com/problems/binary-tree-right-side-view/description/
 *
 * algorithms
 * Medium (63.90%)
 * Likes:    221
 * Dislikes: 0
 * Total Accepted:    44.2K
 * Total Submissions: 69.5K
 * Testcase Example:  '[1,2,3,null,5,null,4]'
 *
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * 
 * 示例:
 * 
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1, 3, 4]
 * 解释:
 * 
 * ⁠  1            <---
 * ⁠/   \
 * 2     3         <---
 * ⁠\     \
 * ⁠ 5     4       <---
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
    /**
     * 解题思路，一开始看到这一题就感觉其实就是将每一层最后一个元素输出
     * 和层次相关那就是  BFS了 
     */
    public List<Integer> rightSideView(TreeNode root) {
        //结果表 
        List<Integer> list = new LinkedList<>();

        //特殊情况处理
        if(root == null)    
            return list;

        //辅助队列
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();//当前层的节点数。
            //循环将最后一个节点放入list中
            for(int i = 0 ; i < size ; ++i){
                //取节点一定要放在for循环中，如果放在外面就不是Bfs了
                TreeNode t = q.poll();
                if(i == size - 1){
                    list.add(t.val);
                }
                if(t.left != null)
                    q.add(t.left);
                if(t.right != null)
                    q.add(t.right);
            }
        }

        return list;
        /**
         * 解题的时候犯的错误：将取当前节点放在了size之前，导致出错  返回[]
         * 
         */
    }
}
// @lc code=end

