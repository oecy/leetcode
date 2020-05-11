import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=98 lang=java
 *
 * [98] 验证二叉搜索树
 *
 * https://leetcode-cn.com/problems/validate-binary-search-tree/description/
 *
 * algorithms
 * Medium (29.63%)
 * Likes:    570
 * Dislikes: 0
 * Total Accepted:    116.4K
 * Total Submissions: 374.5K
 * Testcase Example:  '[2,1,3]'
 *
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * 
 * 假设一个二叉搜索树具有如下特征：
 * 
 * 
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 
 * 
 * 示例 1:
 * 
 * 输入:
 * ⁠   2
 * ⁠  / \
 * ⁠ 1   3
 * 输出: true
 * 
 * 
 * 示例 2:
 * 
 * 输入:
 * ⁠   5
 * ⁠  / \
 * ⁠ 1   4
 * / \
 * 3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 * 根节点的值为 5 ，但是其右子节点值为 4 。
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
     * 解题思路 首先想到的就是递归 
     * 但是实际上来看并不行 对于 [10,5,15,null,null,6,20] 这种二叉树并不能很好的判断 因为右子树的左孩子很容易小于根节点
     * 尝试将二叉树的中序遍历 如果他是递增的则说明是二叉搜索树
     * 只要保证 每次新遍历的节点比上以节点大就行
     * 
     * 坑 ：一定要考虑负数的情况！！！！
     * @param root
     * @return
     */

   

    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        double inorder = -Double.MAX_VALUE;//因为有 [-2147483648] 这个测试用例。。所以。。。

        while(!stack.isEmpty() || root != null){//中序遍历常规代码
            while(root != null ){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(root.val <= inorder)//如果当前值比前一个要小或者相等 直接返回false
                return false;
            inorder = root.val;//记录新的前一节点
            root = root.right; 
        }
        return true;
    }


}
// @lc code=end

