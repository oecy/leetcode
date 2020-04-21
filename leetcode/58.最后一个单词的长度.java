/*
 * @lc app=leetcode.cn id=58 lang=java
 *
 * [58] 最后一个单词的长度
 *
 * https://leetcode-cn.com/problems/length-of-last-word/description/
 *
 * algorithms
 * Easy (32.89%)
 * Likes:    191
 * Dislikes: 0
 * Total Accepted:    83.9K
 * Total Submissions: 254.3K
 * Testcase Example:  '"Hello World"'
 *
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。
 * 
 * 如果不存在最后一个单词，请返回 0 。
 * 
 * 说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。
 * 
 * 
 * 
 * 示例:
 * 
 * 输入: "Hello World"
 * 输出: 5
 * 
 * 
 */

// @lc code=start
class Solution {
    public int lengthOfLastWord(String s) {
        if(s == null || s.length() ==0 )//特殊情况的处理
            return 0;
        s = s.trim();//去除空格
        if(s == null || s.length() == 0)//如果全部都是空格
            return 0;
        int lastSpace = s.lastIndexOf(' ');//最后一个空格的位置
        if(!s.contains(" "))//如果不包含空格的话 直接返回长度
            return s.length();
        return s.substring(lastSpace+1, s.length()).length();

        /**
         * 看完题解之后可以使用的方法 从右往左 遍历
         * 遇到第一个非空格字符开始计数，遇到第二个空格则停止。
         */

    }
}
// @lc code=end

