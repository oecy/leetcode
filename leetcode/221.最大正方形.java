/*
 * @lc app=leetcode.cn id=221 lang=java
 *
 * [221] 最大正方形
 *
 * https://leetcode-cn.com/problems/maximal-square/description/
 *
 * algorithms
 * Medium (39.37%)
 * Likes:    367
 * Dislikes: 0
 * Total Accepted:    43.4K
 * Total Submissions: 104.8K
 * Testcase Example:  '[["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]'
 *
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 * 
 * 示例:
 * 
 * 输入: 
 * 
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * 
 * 输出: 4
 * 
 */

// @lc code=start
class Solution {
    /**
     * 解题思路:遍历每一个元素，如果这个元素为1则队其进行长宽加1操作判断 这个区域是否都为1
     * 
     * 题解解法 动态规划  我们不必从左上角开始向左向右计算。
     * 我们可以 以右下角的点为参考点  如果一个面积为4的正方形，其右下角肯定是1 那么其 
     * 左上角也必然为1. 那怎么判断加入这个点后是否为正方形呢？
     * 为0的位置设置dp为0 为一的位置则dp[i][j] = 1 + min(dp[i-1][j-1],[i][j-1],[i-1][j])
     * 因为只要其左上的三个点有一个为0那么他就不是一个正方形。
     */
    public int maximalSquare(char[][] matrix) {
        /**
         * 注释 部分为第一次的暴力解法
         */
        if(matrix == null )
            return 0;
        int row = matrix.length;
        if(row == 0)
            return 0;
        int col = matrix[0].length;
        if(col == 0)
            return 0;
        //动态规划数组
        int res = 0;//最大步长
        int[][] dp = new int[row][col];
  
        for(int i = 0 ; i < row ; ++i)
            for(int j = 0 ; j < col ; ++j){
                //如果为1的话
                if(matrix[i][j] == '1'){
                    //如果是边缘的位置 直接设为1
                    if( i == 0 || j == 0)
                        dp[i][j] = 1;
                    else{
                        dp[i][j] = 1 + Math.min(Math.min(dp[i-1][j-1], dp[i-1][j]), dp[i][j-1]);
                    }
                }
                else
                    dp[i][j] = 0;
                
                res = Math.max(dp[i][j], res);
            }
        return res * res;
        // if(matrix == null)
        //     return 0;
        // int max = 0;
        // int step = 1;
        // int flag = 0;
        // for(int i = 0 ; i < matrix.length ; ++i)
        //     for(int j = 0 ; j < matrix[0].length ; ++j){
        //         if(matrix[i][j] ==  '1' ){
        //             flag = 1;
        //             while(isSquare(matrix, i, j, step)){
        //                 max = Math.max(max, (step + 1) * (step + 1));
        //                 ++step;
        //             }
        //             step = 1;
        //         }
        //     }
        // if(flag == 1 &&  max == 0)
        //     return 1;
        // return max;

    }

    /**
     * 
     * @param matrix
     * @param x
     * @param y
     * @param step
     * @return
     * 
     * 对于给定的左上角的的顶点以及步长判断当前区域内是否全为1
     */
    // public boolean isSquare(char[][] matrix,int x,int y,int step){
    //     if(x < 0  || y < 0 || x > matrix.length - 1 || y > matrix[0].length - 1
    //       || x + step > matrix.length - 1 || y + step > matrix[0].length - 1)
    //         return false;
    //     for(int i = 0  ; i <= step ; ++i)
    //         for(int j = 0 ; j <= step ; ++j){
    //             if(matrix[i+x][j+y] != '1')
    //                 return false;
    //         }
    //     return true;
    // }
}
// @lc code=end

