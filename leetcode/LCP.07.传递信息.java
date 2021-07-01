import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class Solution {
    //最初的使用map的方法其实也行。注意dfs的退出条件问题
    Map<Integer,List<Integer>> map;

    //使用list来构建 ArrayList其根据add循序而言是有序的
    List<List<Integer>> edges;
    int ans = 0;
    int k = 0;
    int n = 0;
    /** 记录方案数最先想到的就是递归方法，先将所给条件建成图，通过递归，如果递归可以到达目标编号则加1
     */
    public int numWays(int n, int[][] relation, int k) {
        this.k = k;
        this.n = n;
        //根据relation二维数组建立有向图
        //map = new HashMap<>();
        edges = new ArrayList<List<Integer>>();
        for (int i = 0; i < n; i++) {
            edges.add(new ArrayList<Integer>());
        }
        for (int[] edge : relation) {
            int src = edge[0], dst = edge[1];
            edges.get(src).add(dst);
        }
        dfs(0,0);
        
        return ans;

        // dp dp[i][j] 表示经过i轮后到达j节点的方案数
        // int[][] dp = new int[k + 1][n];
        // dp[0][0] = 1;
        // for (int i = 0; i < k; i++) {
        //     for (int[] edge : relation) {
        //         int src = edge[0], dst = edge[1];
        //         dp[i + 1][dst] += dp[i][src];
        //     }
        // }
        // return dp[k][n - 1];
    }

    public void dfs(int v,int depth){
        //这里一定要先判断depth，不然可能会出现死循环。
        if (depth == k){
            if( v == n-1 ){
                ans++; 
            }
            return;
        }
        
        if(map.containsKey(v)){
            for (Integer i : edges.get(v)) {
                dfs(i, depth+1);
            }
        }else{
            return;
        }
    }
}
