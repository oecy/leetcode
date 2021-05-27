/*
 * @lc app=leetcode.cn id=461 lang=golang
 *
 * [461] 汉明距离
 */

// @lc code=start
func hammingDistance(x int, y int) int {
	count := 0
	for x != 0 || y != 0 {
		if x % 2 != y % 2{
			count++
		}
		x , y = x/2,y/2
	}
	return count
}
// @lc code=end

