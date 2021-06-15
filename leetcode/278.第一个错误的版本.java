/*
 * @lc app=leetcode.cn id=278 lang=java
 *
 * [278] 第一个错误的版本
 */

// @lc code=start
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

    /**
     * 思路：类似于用二分搜索，要找到第一个为true的值
     */
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1,right = n;
        while(left < right){
            int mid = left+(right-left)/2;
            if(!isBadVersion(mid)){
                left = mid+1;
            }else{
                right =mid;
            }
        }
        return left;
    }
}
// @lc code=end

