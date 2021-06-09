/*
 * @lc app=leetcode.cn id=1 lang=golang
 *
 * [1] 两数之和
 */

// @lc code=start
func twoSum(nums []int, target int) []int {
	// len := len(nums)
	// var ans [2]int
	// mmap :=make(map[int]int)
	// mmap[nums[0]] = 0
	// for i := 1 ; i < len ; i++ {
	// 	temp := target - nums[i]
	// 	val , ok := mmap[temp]
	// 	if ok {
	// 		ans[0] = nums[val]
	// 		ans[1] = nums[i]
	// 		return ans
	// 	}
	// 	mmap[nums[i]] = i
	// }
	// return ans

	hashTable := map[int]int{}
    for i, x := range nums {
        if p, ok := hashTable[target-x]; ok {
            return []int{p, i}
        }
        hashTable[x] = i
    }
    return nil


}
// @lc code=end

