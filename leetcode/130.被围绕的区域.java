import sun.misc.Queue;

/*
 * @lc app=leetcode.cn id=130 lang=java
 *
 * [130] 被围绕的区域
 *
 * https://leetcode-cn.com/problems/surrounded-regions/description/
 *
 * algorithms
 * Medium (39.94%)
 * Likes:    204
 * Dislikes: 0
 * Total Accepted:    32K
 * Total Submissions: 80.1K
 * Testcase Example:  '[["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]'
 *
 * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
 * 
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 * 
 * 示例:
 * 
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * 
 * 
 * 运行你的函数后，矩阵变为：
 * 
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * 
 * 
 * 解释:
 * 
 * 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O'
 * 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 * 
 */

// @lc code=start
class Solution {

    //位置类  用于标记当前的位置(x,y)
    public class Pos{
        int x;
        int y;
        Pos(int x,int y){
            this.x = x;
            this.y = y;
        }
    }

    public void solve(char[][] board) {
        /**
         * 解题思路  这是一个图的问题。题目中已经说了边界上不存在围绕区间。那么只要找出所有与边界上
         * 的O相连的O。再将剩下的O全部取为X即可。
         */
        if(board == null || board.length == 0)//特殊情况优先处理
            return ;
        int row = board.length;//行
        int col = board[0].length;//列

        if(row <= 2 || col <= 2)//如果只有两行或者两列则必然不会有被包围的区域
            return ;

        for(int i = 0 ; i < row ; ++i)
            for(int j = 0 ; j < col ; ++j){
                boolean isEdge = i==0 || j ==0 || i == row-1 || j == col-1;//是否为边的判断  
                if(isEdge && board[i][j] ==  'O'){//如果为边且对应的值为O
                    bfs(board,i,j);
                }
            }
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (board[i][j] == 'O') {
                        board[i][j] = 'X';
                    }
                    if (board[i][j] == '#') {
                        board[i][j] = 'O';
                    }
                }
            }
        
    }

    void bfs(char[][] board,int i,int j){
        Queue<Pos> queue = new LinkedList<>();
        queue.add(new Pos(i, j));
        board[i][j] = '#';//占位符
        while(!queue.isEmpty()){//如果队列不为空就一直遍历
            Pos cur = queue.poll();
            //上
            if(cur.x - 1 >=0 && board[cur.x-1][cur.y] == 'O'){
                queue.add(new Pos(cur.x-1,cur.y));
                board[cur.x-1][cur.y] = '#';
            }
            //下
            if(cur.x + 1 < board.length && board[cur.x+1][cur.y] == 'O'){
                queue.add(new Pos(cur.x+1,cur.y));
                board[cur.x+1][cur.y] = '#';
            }
            //左
            if(cur.y - 1 >=0 && board[cur.x][cur.y-1] == 'O'){
                queue.add(new Pos(cur.x,cur.y-1));
                board[cur.x][cur.y-1] = '#';
            }
            //右
            if(cur.y + 1 <board[0].length && board[cur.x][cur.y+1] == 'O'){
                queue.add(new Pos(cur.x,cur.y+1));
                board[cur.x][cur.y+1] = '#';
            }

        }
    }
}
// @lc code=end

