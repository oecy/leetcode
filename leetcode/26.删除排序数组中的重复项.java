/*
 * @lc app=leetcode.cn id=26 lang=java
 *
 * [26] 删除排序数组中的重复项
 *
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/description/
 *
 * algorithms
 * Easy (49.39%)
 * Likes:    1396
 * Dislikes: 0
 * Total Accepted:    294.7K
 * Total Submissions: 594.4K
 * Testcase Example:  '[1,1,2]'
 *
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 给定数组 nums = [1,1,2], 
 * 
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。 
 * 
 * 你不需要考虑数组中超出新长度后面的元素。
 * 
 * 示例 2:
 * 
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 * 
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 * 
 * 你不需要考虑数组中超出新长度后面的元素。
 * 
 * 
 * 
 * 
 * 说明:
 * 
 * 为什么返回数值是整数，但输出的答案是数组呢?
 * 
 * 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 * 
 * 你可以想象内部操作如下:
 * 
 * // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
 * int len = removeDuplicates(nums);
 * 
 * // 在函数里修改输入数组对于调用者是可见的。
 * // 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
 * for (int i = 0; i < len; i++) {
 * print(nums[i]);
 * }
 * 
 * 
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        //双指针  快慢指针
        if(nums.length == 0)//如果长度为0 直接返回
            return 0;
        int i = 0;//慢指针
        for(int j  = 1 ; j < nums.length ; j++){//快指针
            if(nums[i] != nums[j]){//如果两者不相等，则将慢指针加1，同时将快指针的元素移动到新的位置  如果两者相等那么慢指针不会移动直到找到新的不等的元素
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
        //一开始的解法：冒泡 但是超出了时间限制。。
        // int count = 1;
        // for(int i = 0 ; i < nums.length ; i++){
        //     for(int j = i+1 ; j < nums.length-1 ; ){
        //         if(nums[i] == nums[j]){
        //             nums[j] = nums[j+1];
        //         }else{
        //             j++;
        //             count++;
        //         }
        //         i = j;
        //     }
        // }
        // if(nums[nums.length - 2] == nums[nums.length - 1]){
        //     return count;
        // }else{
        //     return count+1;
        // }
        

    }
}
// @lc code=end

