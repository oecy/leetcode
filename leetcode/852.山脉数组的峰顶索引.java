/*
 * @lc app=leetcode.cn id=852 lang=java
 *
 * [852] 山脉数组的峰顶索引
 */

// @lc code=start
class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int ans = -1;
        for (int i = 0; i < arr.length-1; i++) {
            if(arr[i]< arr[i+1]){
                continue;
            }else{
                ans = i;
                break;
            }
        }
        return ans;
    }
}
// @lc code=end

