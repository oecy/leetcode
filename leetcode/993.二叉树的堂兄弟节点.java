import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=993 lang=java
 *
 * [993] 二叉树的堂兄弟节点
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
 * 题目中明确给出这两个节点肯定是树中的节点，所以不考虑节点不在树中的情况 堂兄弟节点 深度同，父节点不同。 深度好求，然后用两个pre来表示他们的父节点
 */
class Solution {
    // round1
    /**
     * 思路就采用层次遍历，如果xy在同一层且父节点不同，那么就是true
     */
    // public boolean isCousins(TreeNode root, int x, int y) {
    //     //先判断有没有根节点，有的话直接返回false
    //     if(root.val == x || root.val == y)
    //         return false;
    //     //初始都为根节点
    //     int depthX=0,depthY=0;
    //     int orderX=0 ,orderY=0;
    //     int flag = 0;
    //     int depth = 0;
    //     int order = 1;
    //     Queue<TreeNode> queue = new LinkedList<>();
    //     queue.add(root);
    //     while(!queue.isEmpty()){
    //         if(flag == 2)
    //             break;
    //         int size = queue.size();
    //         for(int i = 0 ; i < size ; i++){
    //             TreeNode t = queue.poll();
    //             if(flag != 2){
    //                 if(t.left != null){
    //                     if(t.left.val == x){
    //                         flag++;
    //                         depthX = depth;
    //                         orderX = order;
    //                     }
    //                     if(t.left.val == y){
    //                         flag++;
    //                         depthY = depth;
    //                         orderY = order;
    //                     }
    //                     queue.add(t.left);
    //                 }
    //                 if(t.right != null){
    //                     if(t.right.val == x){
    //                         flag++;
    //                         depthX = depth;
    //                         orderX = order;
    //                     }
    //                     if(t.right.val == y){
    //                         flag++;
    //                         depthY = depth;
    //                         orderY = order;
    //                     }
    //                     queue.add(t.right);
    //                 }
    //             }
    //             order++;
    //         }
    //         depth++;
    //     }
    //     if(depthX == depthY && orderX != orderY){
    //         return true;
    //     }
    //     return false;
    // }



    //round2 写第一种写法的过程中，突然想到因为大小最多100，所以用一个list存所有的node，
    //再利用二叉树的性质求解 然后想了一下不现实，因为不能判断是树结束了还是单纯的是叶子节点
    //所以改用DFS尝试一下。
    //已经看了题解了，所以之前尝试用DFS的失败在于，可以把父节点也作为参数传递，之前只是
    //把深度作为深度传递。这是一个误区。。。。比较坑爹
    int depthX,depthY;
    TreeNode preX,preY;
    boolean findX=false,findY=false;
    public boolean isCousins(TreeNode root, int x, int y) {
        DFS(root, x, y, 0,null);
        return depthX == depthY && preX != preY;
    }

    public void DFS(TreeNode root,int x,int y,int depth,TreeNode pre){
        if(root.val == x){
            findX = true;
            depthX = depth;
            preX =pre;
        }
        if(root.val == y){
            findY = true;
            depthY = depth;
            preY =pre;
        }
        if(findX&&findY)
            return ;
        if(root.left != null){
            DFS(root.left, x, y, depth+1,root);
        }
        if(root.right != null){
            DFS(root.right, x, y, depth+1,root);
        }
    }


}
// @lc code=end
