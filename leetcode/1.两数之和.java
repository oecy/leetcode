import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 *
 * https://leetcode-cn.com/problems/two-sum/description/
 *
 * algorithms
 * Easy (48.00%)
 * Likes:    7971
 * Dislikes: 0
 * Total Accepted:    950.4K
 * Total Submissions: 2M
 * Testcase Example:  '[2,7,11,15]\n9'
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * 
 * 示例:
 * 
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * 
 * 
 */

// @lc code=start
class Solution {

    /**
     * 改进的方法 将 key 与 value 进行对调,这样可以根据数组的值获取对应的下标
     *           返回的值可以直接  return new int[] { map.get(temp), i };
     * 对于异常的一些处理 使用 throw new IllegalArgumentException("No two sum solution"); 
     * 而非使用 [0][0]代替.
     */
    public int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        int[] answer= new int[2];
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        map.put(0, nums[0]);
        for(int i = 1 ; i < length ; i++){
            int temp = target - nums[i];
            if(map.containsValue(temp)){
                for(int t : map.keySet()){
                    if( temp == map.get(t)){
                        answer[0] = t;
                    }
                }
                answer[1] = i;
                return answer;
            }
            map.put( i , nums[i]);
        }
        answer[0] = 0;
        answer[1] = 0 ;
        return answer;
    }
}
// @lc code=end

