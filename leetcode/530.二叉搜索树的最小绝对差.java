/*
 * @lc app=leetcode.cn id=530 lang=java
 *
 * [530] 二叉搜索树的最小绝对差
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
  * 2020.10.12
  * 第一次见的解题思路：题目中明确说明有两个节点，所以不需要考虑空树和只有一个节点的情况
  * 因为题目中的要求是节点差的最小值，所以节点差必定存在于两个相邻的节点或者说是一队父子节点中
  * 尝试将二叉搜索树进行一次遍历，同时设立两个变量用于存储当前的最小值以及保存父亲节点的值

  * 思路错误：更正 绝对值之差除了可能在一对父子节点中，也有可能出现在父节点和其左孩子的右子树中或者右孩子的左子树中
    
    再次更正，本题是一个排序二叉树 其先序遍历是有序的，所以可以等价为一个有序数组求元素间差值最小
    所以通过一个中序遍历得到其一个升序的序列，这样就可以通过一个变量记录前一个节点的值
  */
class Solution {

    //存放结果变量
    int ans = Integer.MAX_VALUE;

    int pre;

    
    public int getMinimumDifference(TreeNode root) {
        //pre首先定义为一个-1.因为本题节点都非负，所以让第一节点做一个加1运算，方便代码编写，而且也不会出现错误
        //上一条注释 解释不对  [1564,1434,3048,1,null,null,3184] 这个用例 ea为130如果是-1那么会输出2
        //使用 一个判断如果pre = -1则跳过本次相减的判断
        pre = -1;
        midOrder(root);
        return ans;
        //需要定义一个中序遍历
    }


    public void midOrder(TreeNode root){
        if(root == null){
            return;
        }
        midOrder(root.left);
        //chuli
        if(pre != -1){
            ans = Math.min(ans, Math.abs(root.val - pre));
        }
        
        pre = root.val;
        midOrder(root.right);
    }
}
// @lc code=end

