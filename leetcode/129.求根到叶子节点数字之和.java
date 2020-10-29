import java.util.ArrayList;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=129 lang=java
 *
 * [129] 求根到叶子节点数字之和
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

 /**
  * 基础：如果不考虑整型溢出的问题
  * 
  * 思路：二叉树的遍历 先根遍历 寻找到叶子节点
  */
class Solution {

    //stack 用于存储所有的节点的值
    Stack<Integer> stack = new Stack<>();
    //定义返回的结果
    int res = 0;

    public int sumNumbers(TreeNode root) {
        //特殊情况的处理
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return root.val;
        preorder(root);
        return res;

    }

    //定义一个新的函数用于遍历二叉树
    public void preorder(TreeNode root){
        //将本次节点的值入栈
        stack.add(root.val);
        //如果为叶子节点就计算这一轮的值并进行更新
        if(root.left == null && root.right == null){
            int cur = 0;
            int temp = 1 ;
            for(int i= stack.size()-1 ; i >=0 ; i--){
                cur += temp * stack.get(i);
                temp = temp * 10;
            }
            res += cur;
        }
        if(root.left != null)
            preorder(root.left);
        if(root.right != null)
            preorder(root.right);
        //本次节点遍历结束之后要将他出栈
        stack.pop();
    }
}
// @lc code=end

