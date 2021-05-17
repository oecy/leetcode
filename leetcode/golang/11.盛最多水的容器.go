/*
 * @lc app=leetcode.cn id=11 lang=golang
 *
 * [11] 盛最多水的容器
 */

// @lc code=start
func maxArea(height []int) int {
	left := 0
	ans := 0
	right := len(height)-1

	for left < right {
		area := min(height[left],height[right])*(right-left)
		if height[left] < height[right]{
			left++
		} else{
			right--
		}
		if area > ans{
			ans = area
		}
	}
	return ans
}

func min(x,y int) int{
	if x > y {
		return y
	}
	return x
}
// @lc code=end

