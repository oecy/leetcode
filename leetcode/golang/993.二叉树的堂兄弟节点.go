/*
 * @lc app=leetcode.cn id=993 lang=golang
 *
 * [993] 二叉树的堂兄弟节点
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
 //round1 
var l = [4]int{}
func isCousins(root *TreeNode, x int, y int) bool {
	dfs(root,x,y,0,root.Val)
	return l[0]==l[2] && l[1]!=l[3]
}

func dfs(root *TreeNode, x int ,y int, depth int,pre int) {
	if root != nil {
		if root.Val == x {
			l[0] = depth
			l[1] = pre
		}
		if root.Val == y {
			l[2] = depth
			l[3] = pre
		}
		dfs(root.Left,x,y,depth+1,root.Val)
		dfs(root.Right,x,y,depth+1,root.Val)
	}
}
// @lc code=end

