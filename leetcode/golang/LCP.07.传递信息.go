func numWays(n int, relation [][]int, k int) (ans int) {
	edges := make([][]int , n)
	for _ ,r := range relation {
		src , dst := r[0], r[1]
		edges[src] = append(edges[src],dst)
	}

	var dfs func (int , int) 
	dfs = func (v , d int)  {
		if d == k {
			if v == n-1 {
				ans++
			}
			return
		}
		for _ ,y := range edges[v] {
			dfs(y,d+1)
		}
	}
	dfs(0,0)
	return
}