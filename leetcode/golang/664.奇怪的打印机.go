/*
 * @lc app=leetcode.cn id=664 lang=golang
 *
 * [664] 奇怪的打印机
 */

// @lc code=start
func strangePrinter(s string) int {
	len := len(s)
	dp := make([][]int,len)
	for i := range dp{
		dp[i] = make([]int, len)
	}
	min := func (a,b int) int {
		if a > b {
			return b
		}
		return a
	}
	for i := len-1 ; i >= 0 ; i-- {
		dp[i][i] = 1
		for  j := i+1 ; j < len ; j++{
			if s[i] == s[j] {
				dp[i][j] = dp[i][j-1]
			}else{
				minn := 2147483645
				for k := i ; k < j ; k++{
					minn = min(minn,dp[i][k]+dp[k+1][j])
				} 
				dp[i][j] = minn
			}
		} 
	}

	return dp[0][len-1]
}
// @lc code=end

