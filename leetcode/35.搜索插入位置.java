/*
 * @lc app=leetcode.cn id=35 lang=java
 *
 * [35] 搜索插入位置
 *
 * https://leetcode-cn.com/problems/search-insert-position/description/
 *
 * algorithms
 * Easy (45.37%)
 * Likes:    486
 * Dislikes: 0
 * Total Accepted:    143.6K
 * Total Submissions: 316.2K
 * Testcase Example:  '[1,3,5,6]\n5'
 *
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 
 * 你可以假设数组中无重复元素。
 * 
 * 示例 1:
 * 
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 
 * 
 * 示例 2:
 * 
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 
 * 
 * 示例 3:
 * 
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 
 * 
 * 示例 4:
 * 
 * 输入: [1,3,5,6], 0
 * 输出: 0
 * 
 * 
 */

// @lc code=start
class Solution {
    //二分法！！
    public int searchInsert(int[] nums, int target) {
        int length = nums.length;
        //特殊情况优先判断一下 即要插入的数超出这个有序数组的范围
        if(target < nums[0])
            return 0;
        if(target > nums[length - 1])
            return length;
        //二分法
        int left = 0;
        int right = length - 1;
        while( left < right){
            int mid = left + ( right - left ) / 2;//之所以这么写时left + right 可能溢出
            //如果 nums[mid] 小于 target 则必然不是解
            if( nums[mid] < target){
                left = mid + 1;
            }
            else{
                right = mid;
            }
        }
        return left;

    }
}
// @lc code=end

