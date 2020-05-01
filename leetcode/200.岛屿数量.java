import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=200 lang=java
 *
 * [200] 岛屿数量
 *
 * https://leetcode-cn.com/problems/number-of-islands/description/
 *
 * algorithms
 * Medium (47.88%)
 * Likes:    548
 * Dislikes: 0
 * Total Accepted:    101K
 * Total Submissions: 204.9K
 * Testcase Example:  '[["1","1","1","1","0"],["1","1","0","1","0"],["1","1","0","0","0"],["0","0","0","0","0"]]'
 *
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。
 * 
 * 此外，你可以假设该网格的四条边均被水包围。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 * 输出: 1
 * 
 * 
 * 示例 2:
 * 
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 * 输出: 3
 * 解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
 * 
 * 
 */

// @lc code=start
class Solution {
    /**
     * 解题思路:明显这是一个图的问题，从某一为1的节点开始搜索，将所有可以与之邻接
     * 的陆地计算其中，记为一个岛屿。
     * 然后按照上述思路遍历整个图
     */

     //辅助类记录坐标
    public class Pos{
        int x;
        int y;
        Pos(int _x,int _y){
            x = _x;
            y = _y;
        }

    }
    //是否访问标记 一开始超时以为是Set的原因  后来发现是我自己在bfs中没有加上是否已访问的判断
    //Set<Pos> visited = new HashSet<>();


    public int numIslands(char[][] grid) {
        //特殊情况优先处理掉
        if(grid == null || grid.length == 0)
            return 0;

        //行数 与 列数
        int row = grid.length;
        int col = grid[0].length;
    
        //访问标记数组，1为已访问 0为未访问
        int[][] visited = new int[row][col];
        
        int ans = 0;

        for(int i = 0;i < row ; ++i)
            for(int j = 0 ; j < col ; ++j){
                if(grid[i][j] == '1' && visited[i][j] == 0){
                    bfs(grid,i,j,visited);
                    ans++;
                }
            }

        return ans;
        /**
         * 看了题解之后才发现其实根本不需要使用visited函数，我们可以直接将访问过的1置0。
         * 这样就避免了许多不必要的判断
         */

    }

    public void bfs(char[][] grid,int x,int y,int[][] visited){
        //辅助队列BFS算法
        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(x,y));//入队
        visited[x][y] = 1;//标记已访问

        while(!q.isEmpty()){
            //取出当前节点
            Pos cur = q.poll();

            //上方   之所以超出时间限制 因为没有加上是否已访问的判断
            if(cur.x-1 >= 0 && grid[cur.x-1][cur.y] == '1' && visited[cur.x-1][cur.y] == 0){
                q.add(new Pos(cur.x-1,cur.y));
                visited[cur.x-1][cur.y] = 1;
            }
            //下方
            if(cur.x+1 < grid.length && grid[cur.x+1][cur.y] == '1' && visited[cur.x+1][cur.y] == 0){
                q.add(new Pos(cur.x+1,cur.y));
                visited[cur.x+1][cur.y] = 1;
            }
            //左方
            if(cur.y-1 >= 0 && grid[cur.x][cur.y-1] == '1' && visited[cur.x][cur.y-1] == 0){
                q.add(new Pos(cur.x,cur.y-1));
                visited[cur.x][cur.y-1] = 1;
            }
            //右方
            if(cur.y+1 < grid[0].length && grid[cur.x][cur.y+1] == '1' && visited[cur.x][cur.y+1] ==0 ){
                q.add(new Pos(cur.x,cur.y+1));
                visited[cur.x][cur.y+1] = 1;
            }
        }
    }
}
// @lc code=end

