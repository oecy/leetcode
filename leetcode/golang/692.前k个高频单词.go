/*
 * @lc app=leetcode.cn id=692 lang=golang
 *
 * [692] 前K个高频单词
 */

// @lc code=start
// 实现优先队列
type pair struct {
	w string
	c int
}
type hp []pair
func (h hp) Len() int {return len(h)}
func (h hp) Less(i,j int) bool  {
	a,b := h[i],h[j]
	return a.c < b.c || a.c == b.c && a.w > b.w
}
func (h hp) Swap(i, j int)       { h[i], h[j] = h[j], h[i] }
func (h *hp) Push(v interface{}) { *h = append(*h, v.(pair)) }
func (h *hp) Pop() interface{}   { a := *h; v := a[len(a)-1]; *h = a[:len(a)-1]; return v }

func topKFrequent(words []string, k int) []string {
	// //基础map加 排序的实现
	 cnt := map[string]int{}
	 for _ , w := range words{
	 	cnt[w]++
	 }
	//  // 注意make的用法 如果是两个参数 第二个参数是指定长度，如果有三个参数，那么第二个参数是切片的长度，第三个参数是预留的空间长度
	//ans := make([]string,0,len(cnt))
	// for w := range cnt {
	// 	ans = append(ans,w)
	// }
	// sort.Slice(ans,func( i,j int) bool{
	// 	s, t := ans[i], ans[j]
	// 	return cnt[s] > cnt[t] || cnt[s] == cnt[t] && s < t
	// })
	// return ans[:k]

	// 优先队列的实现
	h := &hp{}
	// for w, c := range cnt {
	// 	heap.Push(h,pair{w,c})
	// 	if h.Len() > k {
	// 		heap.Pop(h)
	// 	}
	// }
	for w, c := range cnt {
        heap.Push(h, pair{w, c})
        if h.Len() > k {
            heap.Pop(h)
        }
    }
	ans := make([]string,k)
	for i := k - 1; i >= 0; i-- {
        ans[i] = heap.Pop(h).(pair).w
    }
	return ans
	
}
// @lc code=end

