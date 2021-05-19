/*
 * @lc app=leetcode.cn id=1738 lang=golang
 *
 * [1738] 找出第 K 大的异或坐标值
 */

// @lc code=start
func kthLargestValue(matrix [][]int, k int) int {
	//异或 前缀和
	m := len(matrix)
	n := len(matrix[0])
	s := make([][]int,m+1)
	s[0] = make([]int,n+1)
	result := make([]int,0,m*n)
	// 如果使用参数赋值维度 必须使用make
	//var s [m+1][n+1]int
	for i,row := range matrix {
		s[i+1] = make([]int,n+1)
		for j,val := range row {
			s[i+1][j+1] = s[i][j] ^ s[i+1][j] ^ s[i][j+1] ^ val
			result = append(result,s[i+1][j+1])
		}
	}
	sort.Sort(sort.Reverse(sort.IntSlice(result)))
	//排序
	return result[k-1]
}
// @lc code=end

