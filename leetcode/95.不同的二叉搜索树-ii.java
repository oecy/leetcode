import java.util.LinkedList;
import java.util.List;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=95 lang=java
 *
 * [95] 不同的二叉搜索树 II
 *
 * https://leetcode-cn.com/problems/unique-binary-search-trees-ii/description/
 *
 * algorithms
 * Medium (62.28%)
 * Likes:    374
 * Dislikes: 0
 * Total Accepted:    29.4K
 * Total Submissions: 47K
 * Testcase Example:  '3'
 *
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。
 * 
 * 示例:
 * 
 * 输入: 3
 * 输出:
 * [
 * [1,null,3,2],
 * [3,2,null,1],
 * [3,1,null,null,2],
 * [2,1,3],
 * [1,null,2,null,3]
 * ]
 * 解释:
 * 以上的输出对应以下 5 种不同结构的二叉搜索树：
 * 
 * ⁠  1         3     3      2      1
 * ⁠   \       /     /      / \      \
 * ⁠    3     2     1      1   3      2
 * ⁠   /     /       \                 \
 * ⁠  2     1         2                 3
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

    public List<TreeNode> generate_trees(int start , int end){
        //当前循环下 所有树的根节点的链表
        List<TreeNode> all_trees = new LinkedList<>();
        //如果start > end 则说明是到了边界情况就不会有树了
        if(start > end){
            all_trees.add(null);
            return all_trees;
        }

        for(int i = start ; i <= end ; ++i){
            //对于以i为根节点的左子树
            List<TreeNode> left_trees = generate_trees(start, i-1);
            //对于以i为根节点右子树
            List<TreeNode> right_trees = generate_trees(i+1, end);

            //对于左子树和右子树而言 以i为根的树一共有 左子树数量 * 右子树数量 种构成
            for(TreeNode l : left_trees)
                for(TreeNode r : right_trees){
                    TreeNode cur = new TreeNode(i);//以i为值得根节点
                    cur.left = l;//赋值左子树
                    cur.right = r;//辅助右子树
                    all_trees.add(cur);//将该树放入所有树得表中
                }
        }

        return all_trees;
    }
    public List<TreeNode> generateTrees(int n) {
        if(n == 0)
            return new LinkedList<TreeNode>();
        return generate_trees(1,n);

    }
}
// @lc code=end

