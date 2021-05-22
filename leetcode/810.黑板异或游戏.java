 /*
 * @lc app=leetcode.cn id=810 lang=java
 *
 * [810] 黑板异或游戏
 */

// @lc code=start
class Solution {
    public boolean xorGame(int[] nums) {
        /**
         * 换个思路就是从数组中每次选择一个进行异或两边人轮流选，选到异或和为0的人输了
         */
        /**
         * 上述思路错误。。
         * 只能说 数学 博弈论 永远的神。。。 太离谱了
         */
        int len = nums.length;
        if( len % 2 == 0 ){
            return true;
        }
        int ans = 0;
        for (int i = 0; i < len; i++) {
            ans ^= nums[i];
        }
        return ans == 0;
    }
}
// @lc code=end

