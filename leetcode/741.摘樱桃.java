/*
 * @lc app=leetcode.cn id=741 lang=java
 *
 * [741] 摘樱桃
 */

// @lc code=start

import java.util.Arrays;

/**
 * 错误思路：第一遍贪心从左上到右下，第二遍右下到左上，将两个得分相加，但是两个局部最优不一定是全局最优
 * 从左上走到右下，再走回去相当于 两个人同时从左上走到右下，然后两人同时到达右下时得分总和求最大值
 * 从左上走到右下因为限制走的总步数是一定的 对于n*n的格子而言 其最大步数是 2*n-2 步
 * 然后两个人同时进行出发 dp[i][x1][x2]  i为当前的步数 x1  x2为两个人的横坐标
 * 
 * 那么状态转移方程就有四种情况
 * dp[i-1][x1][x2]     ->      横坐标不变两人都向下走了一步
 * dp[i-1][x1-1][x2]   ->      第一个人向右第二个人向下
 * dp[i-1][x1][x2-1]   ->      第一个人向下第二个人向右
 * dp[i-1][x1-1][x2-1] ->      两个人都向右
 * 然后加上 两个人当前格子的分数，需要注意的是 如果两人在同一个格子那分数只算一次
 */
class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        //初始化 因为要取最大值所以初始化为最小值
        int dp[][][] = new int[n*2-1][n][n];
        for(int i = 0 ; i < 2*n-1; i++){
            for(int j = 0 ;j < n ; j++){
                Arrays.fill(dp[i][j], Integer.MIN_VALUE);
            }
        }
        dp[0][0][0] = grid[0][0];
        //从第一步开始动态规划
        for(int i = 1 ; i < n*2-1 ; i++){
            //第一个人的位置  横坐标为0和i-(n-1)的最大值  最大值就是 n-1,即走到最右边了  因为i的最大值是2*n-2  
            for(int x1 = Math.max(i-n+1,0) ; x1 <=Math.min(i, n-1);x1++){
                int y1 = i - x1;
                //走不过去直接跳过
                if(grid[x1][y1] == -1){
                    continue;
                }
                //第二个人
                for(int x2 = x1; x2<= Math.min(i,n-1);x2++){
                    int y2 = i-x2;

                    if(grid[x2][y2] == -1){
                        continue;
                    }
                    //四种不同的转移情况
                    int res = dp[i-1][x1][x2];
                    if(x1 > 0){
                        res = Math.max(res, dp[i-1][x1-1][x2]);
                    }
                    if(x2>0){
                        res = Math.max(res, dp[i-1][x1][x2-1]);
                    }

                    if(x1 >0 && x2>0){
                        res = Math.max(res, dp[i-1][x1-1][x2-1]);
                    }
                    //加上两个人当前的格子的分数
                    res += grid[x1][y1];
                    if(x2 != x1){
                        res += grid[x2][y2];
                    }

                    dp[i][x1][x2] = res;
                }
            }


        }

        return Math.max(dp[2*n-2][n-1][n-1], 0);

    }
}
// @lc code=end

