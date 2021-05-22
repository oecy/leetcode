/*
 * @lc app=leetcode.cn id=1035 lang=golang
 *
 * [1035] 不相交的线
 */

// @lc code=start
func maxUncrossedLines(nums1 []int, nums2 []int) int {
	//动态规划 注意 不相等的时候的条件
	m , n := len(nums1) , len(nums2)
	dp := make([][]int , m+1)
	for i := range dp{
		dp[i] = make([]int , n+1)
	}
	for i , v1 := range nums1 {
		for j , v2 := range nums2{
			if v1 == v2 {
				dp[i+1][j+1] = dp[i][j] + 1
			}else{
				dp[i+1][j+1] = max(dp[i][j+1],dp[i+1][j])
			}
		}
	}
	return dp[m][n]
}

func max( a,b int) int {
	if a > b {
		return a
	}
	return b
}
// @lc code=end

