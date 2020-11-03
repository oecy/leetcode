/*
 * @lc app=leetcode.cn id=941 lang=java
 *
 * [941] 有效的山脉数组
 */

// @lc code=start

/**
 * 注意点：
 * 一定 要考虑到各种情况
 * 比如先降后升,一直升，一直降等
 */
class Solution {
    public boolean validMountainArray(int[] A) {
        if(A == null || A.length < 3)
            return false;
        //设立两个标志位
        int upflag = 1, downflag = 0;
        if(A[0]>= A[1])
            return false;
        for (int i = 1; i < A.length; i++) {
            if(upflag == 1){
                if(A[i-1] < A[i])
                    continue;
                if(A[i-1]>A[i]){
                    downflag = 1;
                    upflag = 0;
                    continue;
                }
                else
                    return false;
            }
            if(downflag == 1){
                if(A[i-1] < A[i])
                    return false;
                if(A[i-1]>A[i]){
                    continue;
                }
                else
                    return false;
            }
        }
        if(downflag == 1)
            return true;
        return false;

    }
}
// @lc code=end

