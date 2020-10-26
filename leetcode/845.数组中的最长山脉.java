/*
 * @lc app=leetcode.cn id=845 lang=java
 *
 * [845] 数组中的最长山脉
 */

// @lc code=start

/**
 * 思路：这是看了大佬的评论之后得出的解法  有限状态机
 * 
 * 最长的山脉进行统计之时一共有三种状态
 * Status0  ： left = right 即是平地状态
 * Status1  ： left < right 即是上升状态
 * Status2  ： left > right 下降状态
 * 
 * 状态转移
 * when status0 : left <right go status1 ; left = right go status0 ; if left > right go status0
 * when status1 : left < right status1 ; left = right go 0 ; left > right go 2
 * when status2 : left <right go status1; left = right go 0 ; left > right go 2 
 */
class Solution {
    public int longestMountain(int[] A) {
        int max = 0;
        int status = 0;
        int left = 0;
        for(int i = 1 ; i < A.length ; i++){
            if(status == 0){
                if(A[i-1] < A[i]){
                    status = 1;
                    left = i-1;
                }
            }
            if(status == 1){
                if(A[i-1] == A[i]){
                    status = 0;
                }
                if(A[i-1] > A[i]){
                    status = 2;
                }
            }
            //在状态2的情况下,如果转移出状态2就要计算山脉长度
            if(status == 2){
                if(A[i-1] == A[i]){
                    status = 0;
                    max = Math.max(max, i - left);    
                }
                if(A[i-1]<A[i]){
                    status = 1;
                    max = Math.max(max, i - left);   
                    left = i-1;
                     
                }      
            }
        }

        //对最后一个元素进行处理
        if(status == 2)
            if(A[A.length-2] > A[A.length-1])
                max = Math.max(max, A.length - left);
        return max;

    }
}
// @lc code=end

