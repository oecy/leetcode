/*
 * @lc app=leetcode.cn id=810 lang=golang
 *
 * [810] 黑板异或游戏
 */

// @lc code=start
func xorGame(nums []int) bool {
	//数学永远的神
	len := len(nums)
	if len % 2 == 0{
		return true
	}
	ans := 0
	for _ ,val := range nums{
		ans ^= val
	}
	return ans == 0
}
// @lc code=end

