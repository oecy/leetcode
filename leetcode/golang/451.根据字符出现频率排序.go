/*
 * @lc app=leetcode.cn id=451 lang=golang
 *
 * [451] 根据字符出现频率排序
 */

// @lc code=start
func frequencySort(s string) string {
	//新建 map 存储字符以及其出现的次数
	cnt := map[byte]int{}
    for i := range s {
        cnt[s[i]]++
    }
	//新建pair 用于创建k，v数组
    type pair struct {
        ch  byte
        cnt int
    }
    pairs := make([]pair, 0, len(cnt))
    for k, v := range cnt {
        pairs = append(pairs, pair{k, v})
    }
    sort.Slice(pairs, func(i, j int) bool { return pairs[i].cnt > pairs[j].cnt })

    ans := make([]byte, 0, len(s))
    for _, p := range pairs {
        ans = append(ans, bytes.Repeat([]byte{p.ch}, p.cnt)...)
    }
    return string(ans)
}
// @lc code=end

