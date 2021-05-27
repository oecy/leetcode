import java.util.Arrays;
import java.util.Collections;

/*
 * @lc app=leetcode.cn id=1707 lang=java
 *
 * [1707] 与数组中元素的最大异或值
 */

// @lc code=start
class Solution {
    public int[] maximizeXor(int[] nums, int[][] queries) {
        int len = queries.length;
        int[] ans = new int[len];
        //对nums进行一个排序
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            int temp = -1;
            for(int j= 0 ; j < nums.length ; ++j){
                //对于 nums[j] < mi进行处理
                if( nums[j] <= queries[i][1]){
                    temp = Math.max(temp, queries[i][0] ^ nums[j]);
                }else{
                    //注意处理所有元素都小于mi的情况
                    if(j == 0)
                        temp = -1;
                    break;
                }
            }
            ans[i] = temp;
        }
        return ans;
    }
}
// @lc code=end

