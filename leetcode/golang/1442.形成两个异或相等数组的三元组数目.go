/*
 * @lc app=leetcode.cn id=1442 lang=golang
 *
 * [1442] 形成两个异或相等数组的三元组数目
 */

// @lc code=start
/** 前缀和
*/
func countTriplets(arr []int) (ans int) {

	// //go中返回时可以指定某一个数据为返回的值，比如返回值指定为 (ans int)那么会自动返回ans
	// 求解子串异或为0的解法
	for i := 0; i < len(arr); i++ {
		t := arr[i]
		for k := i+1; k < len(arr); k++ {
			t ^= arr[k]
			if t == 0 {
				ans += k-i
			}
		}
	}
	return 
	// //两次循环
	// ans := 0
	// length := len(arr)
	// // go中数组最好用make 不然会报错。如果是直接写 456数字这种可以的
	// s := make([]int, length+1)
	// // go中的循环一个数组可以 带序号以及对应的值的，不需要写arr[i]这种东西了
	// for i, val := range arr {
    //     s[i+1] = s[i] ^ val
    // }
	// for i := 0; i < length; i++ {
	// 	for k := i+1; k < length; k++ {
	// 		if s[i] == s[k+1] {
	// 			ans += k-i
	// 		}
	// 	}
	// }
	// return ans
}
// @lc code=end

