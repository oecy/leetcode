import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;



/*
 * @lc app=leetcode.cn id=104 lang=java
 *
 * [104] 二叉树的最大深度
 *
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/description/
 *
 * algorithms
 * Easy (72.67%)
 * Likes:    513
 * Dislikes: 0
 * Total Accepted:    162.8K
 * Total Submissions: 223.2K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * 给定一个二叉树，找出其最大深度。
 * 
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * 
 * 说明: 叶子节点是指没有子节点的节点。
 * 
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 返回它的最大深度 3 。
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
    public int maxDepth(TreeNode root) {
        // if( root == null)
        //     return 0;
        // TreeNode[] q = new TreeNode[100000];
        // int front = -1,rear = -1;//头尾指针
        // int last = 0 ,level = 0;//last标志本层最右节点，level标志层数
        // q[++rear] = root;//根节点入队 
        // TreeNode temp;
        // while(front < rear){
        //     //队列不为空时
        //     temp = q[++front];//出队，当前正在访问的节点；
        //     if(temp.left != null){
        //         q[++rear] = temp.left;//左孩子不为空，入队
        //     }    
        //     if(temp.right != null){
        //         q[++rear] = temp.right;
        //     }
        //     if( front == last){//如果到当前层的最后一个节点 则将层次加1，并更新新的last
        //         level++;
        //         last = rear;
        //     }
        // }
        // return level;
        

        //以下是看了题解之后使用bfs的代码
        if(root == null)//特殊情况先处理掉
            return 0;
        Queue<TreeNode> q = new LinkedList<>();
        int depth = 0;//深度
        q.add(root);//根节点入队
        while(!q.isEmpty()){
            //当队列不为空时
            int size = q.size();//当前层 一共有多少节点
            for(int i = 0 ; i < size  ; ++i){
                TreeNode t = q.poll();
                if(t.left != null)
                    q.add(t.left);
                if(t.right != null)
                    q.add(t.right);
            }
            depth++;
        }
        return depth;
    }

}

// @lc code=end

