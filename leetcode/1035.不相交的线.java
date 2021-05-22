import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1035 lang=java
 *
 * [1035] 不相交的线
 */

// @lc code=start
class Solution {
    /**
     * 读题：不相交意味着 ij这条线与mn这条线的关系是
     * (i<m && j < n) || (i> m&& j>n)
     * 统一用大于表示机mn在ij的右侧 好判断。
     * 如果nums2中有多个值和nums1中的数相符合，那么肯定是最左边的那个数更好一点。
     */
    /**
     *  自己的解题思路：第一次的思路错误了。第一次的思路只是考虑了两两连线，但是
     * 没有考虑到 并不是所有的相同的依次连结好就会是最优解 错误的样例
     * [1,1,2,1,2]
     * [1,3,2,3,1]
     * 上述样例就是一个例子 他的最大值是3 而不是2
     * 
     * 
     * 2 第二次的思路，从左和右两边同时进行遍历   
     * 两次都不对。。真的太蠢了
     * 
     * 
     * 看了 题解的思路在最后的代码中。
     */
    public int maxUncrossedLines(int[] nums1, int[] nums2) {



        /**
         * 以下注释部分为自己的思路   垃圾 错误
         */
        //int ans = 0;
        //上下都要记录
        // int top = -1;
        // int bot = -1;
        // for(int i = 0 ; i < nums1.length ; ++i){
        //     for(int j = 0 ; j < nums2.length ; ++j){
        //         //上下两个数相等的时候才进行计算
        //         if(nums1[i] == nums2[j]){
        //             //如果说j比当前的最新的连线的下标还要大那么说明这是可以连成一条线的
        //             if( bot < j){
        //                 top = i;
        //                 bot = j;
        //                 ans++;
        //                 //如果可以连成一条线 直接结束一轮内循环
        //                 break;
        //             }else{

        //             }
        //         }
        //     }
        // }
        
        /**
         * 下面自己这个动态规划的思路是对的但是两者不相等的情况下 条件没处理对
         */
        //定义一个结果二维矩阵A[i][j] ij表示如果这两点相连接，最大的线的个数
        //公式就是i-1 和 j-1连接的情况下的最大值加1
        int m = nums1.length,n = nums2.length;
        int[][] a = new int[m+1][n+1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(nums1[i] == nums2[j]){
                //如果两者可以连线的情况下 要计算最大值
                    a[i+1][j+1] = a[i][j] + 1;
                }else{
                    //两者不可以连线的情况下的处理，其赋值不能直接是ij。
                    a[i+1][j+1] =Math.max(a[i][j+1], Math.max(a[i+1][j],a[i][j]));
                }
            }
        }
        
        return a[m][n];


        /**
         * 正确的解题思路 ： 动态规划 即最长公共子序列
         *  优化的空间：可以使用 一维数组进行dp
         *  在dp的过程中，每一轮循环都新建一个临时的数组，最后赋值给dp数组
         */
    }
}
// @lc code=end

