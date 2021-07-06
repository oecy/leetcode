/*
 * @lc app=leetcode.cn id=1418 lang=golang
 *
 * [1418] 点菜展示表
 */

// @lc code=start
func displayTable(orders [][]string) [][]string {
	// 从订单中获取餐品名称和桌号，统计每桌点餐数量
    nameSet := map[string]struct{}{}
    foodsCnt := map[int]map[string]int{}
    for _, order := range orders {
		//strconv.Atoi stcconv是字符串转换包，Atoi是字符串转int的方法
        id, _ := strconv.Atoi(order[1])
        food := order[2]
        nameSet[food] = struct{}{}
		//统计餐品数量，如果当前桌号没有初始化则初始化
        if foodsCnt[id] == nil {
            foodsCnt[id] = map[string]int{}
        }
        foodsCnt[id][food]++
    }

	// 提取餐品名称，并按字母顺序排列  这里和java类似都需要用一个list类型
    n := len(nameSet)
    names := make([]string, 0, n)
    for name := range nameSet {
        names = append(names, name)
    }
	//sort包 是排序包Strings用于string排序
    sort.Strings(names)

	// 提取桌号，并按餐桌桌号升序排列
    m := len(foodsCnt)
    ids := make([]int, 0, m)
    for id := range foodsCnt {
        ids = append(ids, id)
    }
    sort.Ints(ids)

    // 填写点菜展示表
    table := make([][]string, m+1)
    table[0] = make([]string, 1, n+1)
    table[0][0] = "Table"
	//append 可以将一个数组的原色全部加入某一个数组 使用 ...即可
    table[0] = append(table[0], names...)
    for i, id := range ids {
        cnt := foodsCnt[id]
        table[i+1] = make([]string, n+1)
		//I to a 是int转为string类型的方法
        table[i+1][0] = strconv.Itoa(id)
        for j, name := range names {
            table[i+1][j+1] = strconv.Itoa(cnt[name])
        }
    }
    return table

}
// @lc code=end

