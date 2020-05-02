import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 *
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/description/
 *
 * algorithms
 * Medium (33.59%)
 * Likes:    3561
 * Dislikes: 0
 * Total Accepted:    459.1K
 * Total Submissions: 1.3M
 * Testcase Example:  '"abcabcbb"'
 *
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 
 * 示例 1:
 * 
 * 输入: "abcabcbb"
 * 输出: 3 
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 
 * 
 * 示例 2:
 * 
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 
 * 
 * 示例 3:
 * 
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        //特殊情况优先处理
        if( s == null || s.length() == 0) 
            return 0;
        int len = s.length();
        //存储当前字串的所有字符以及其在s中的位置 
        Map<Character,Integer> map =  new HashMap<>();
        //最小值
        int max = Integer.MIN_VALUE;
        //慢指针  标记上一个相似的字符
        int slow = 0;

        // for(int i = 0 ; i < len ; ++i){
        //     //第三次错误： 需要处理最长字串在最后的问题
        //     //如果当前字符在list中不存在则继续
        //     if(!map.containsKey(s.charAt(i))){
        //         map.put(s.charAt(i), i);
        //         //如果到最后一个字符都不同的话  一定要加1
        //         if( i == len - 1){
        //             max = Math.max(max, i - slow + 1 );
        //         }
        //     }
        //     else{
        //         //取得新的最小值
        //         int curMax = i - slow;
        //         max = Math.max(max, curMax);
        //         //更新slow指针
        //         int preSlow = slow;
        //         slow = map.get(s.charAt(i))+1;
        //         for(int j = preSlow ; j < slow ; ++j){
        //             map.remove(s.charAt(j),j);
        //         }
        //         map.put(s.charAt(i), i);
        //     }
        // }

        //看完题解后的优化 每次的判断条件改为当检测到相同字符的时候更新慢指针
        for(int i = 0 ; i < len ; ++i){
            if(map.containsKey(s.charAt(i)))
                //更新慢指针 
                slow = Math.max(slow,map.get(s.charAt(i))+1);
            //将字符入栈，如果是相同的字符话也入栈，更新value
            map.put(s.charAt(i), i);
            //求最大值
            max = Math.max(max, i -  slow + 1);
        }

        return max;
        //第二次错误 处理字符都不同的情况
        //return map.size() == len ? len : max;

    }
}
// @lc code=end

