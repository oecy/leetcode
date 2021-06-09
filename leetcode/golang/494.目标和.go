 /*
 * @lc app=leetcode.cn id=494 lang=golang
 *
 * [494] 目标和
 */

// @lc code=start
func findTargetSumWays(nums []int, target int) (count int) {

	/**
	*  1、回溯法

	*/
	// count := 0
	// backtrace := func (nums []int , target int, index int , sum int)  {
	// 	if index == len(nums){
	// 		if target == sum{
	// 			count++;
	// 		}
	// 	}else{
	// 		backtrace(nums,target,index+1,sum+nums[index])
	// 		backtrace(nums,target,index+1,sum-nums[index])
	// 	}
	// } 

	// backtrace(nums,target,0,0)
	// return count
	var backtrack func(int, int)
    backtrack = func(index, sum int) {
        if index == len(nums) {
            if sum == target {
                count++
            }
            return
        }
        backtrack(index+1, sum+nums[index])
        backtrack(index+1, sum-nums[index])
    }
    backtrack(0, 0)
    return

}
// @lc code=end

