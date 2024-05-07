/*
 * @lc app=leetcode.cn id=1463 lang=java
 *
 * [1463] 摘樱桃 II
 */

// @lc code=start

import java.util.Arrays;
class Solution {
    public int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][][] dp= new int[m][n][n];
        //初始化为-00   表示那些不可达的情况
        //其实两个的路径是在一个三角形中，所以一些情况可以舍去
        for(int i = 0 ;i <m ;i++){
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], Integer.MIN_VALUE);
            }
        }


        dp[0][0][n-1] = grid[0][0] + grid[0][n-1];


        for(int x=1; x < m ; x++){

            for(int y1 = 0 ; y1 < n ; y1++){

                for(int y2 = n-1 ; y2 >=0; y2--){
                    int res = dp[x-1][y1][y2];
                    if(y2 < n-1){
                        res = Math.max(res, dp[x-1][y1][y2+1]);
                    }
                    if(y2 >0){
                        res = Math.max(res, dp[x-1][y1][y2-1]);
                    }

                    
                    if(y1 > 0){
                        if(y2 < n-1){
                            res = Math.max(res, dp[x-1][y1-1][y2+1]);
                        }
                        if(y2 >0){
                            res = Math.max(res, dp[x-1][y1-1][y2-1]);
                        }

                        res = Math.max(res,dp[x-1][y1-1][y2]);
                    }
                    if(y1 <n-1){
                        if(y2 < n-1){
                            res = Math.max(res, dp[x-1][y1+1][y2+1]);
                        }
                        if(y2 >0){
                            res = Math.max(res, dp[x-1][y1+1][y2-1]);
                        }

                        res = Math.max(res,dp[x-1][y1+1][y2]);
                    }
                    
                    res += grid[x][y1];
                    if(y1 != y2){
                        res += grid[x][y2];
                    }
                    dp[x][y1][y2] = res;
                }
            }
        }


        int ans = 0;
        for (int i = 0; i < n; i++) {
            for(int j=0;j<n ; j++){
                ans = Math.max(ans, dp[m-1][i][j]);
            }
        }

        return ans;
    }
}
// @lc code=end

