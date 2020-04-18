/*
 * @lc app=leetcode.cn id=28 lang=java
 *
 * [28] 实现 strStr()
 *
 * https://leetcode-cn.com/problems/implement-strstr/description/
 *
 * algorithms
 * Easy (39.66%)
 * Likes:    419
 * Dislikes: 0
 * Total Accepted:    156.7K
 * Total Submissions: 395K
 * Testcase Example:  '"hello"\n"ll"'
 *
 * 实现 strStr() 函数。
 * 
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置
 * (从0开始)。如果不存在，则返回  -1。
 * 
 * 示例 1:
 * 
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 
 * 
 * 示例 2:
 * 
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 
 * 
 * 说明:
 * 
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * 
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 * 
 */

// @lc code=start
class Solution {
    //立即想到模式匹配
    public int strStr(String haystack, String needle) {
        //双指针的思想
        if(needle == null)//特殊情况先处理掉
            return 0;
        int i = 0,j = 0;
        while(i < haystack.length() && j < needle.length()){
            if(haystack.charAt(i) == needle.charAt(j)){//如果 匹配成功继续匹配下一个字符
                j++;
                i++;
            }
            else{//匹配失败 则将j重置为0。i重置为这一次匹配的下一个位置。
                i = i - j + 1;
                j = 0;
            }
        }
        if(j >= needle.length()) //如果j>length则说明匹配成功了
            return i - needle.length();
        else 
            return -1;
        
    }


  
}
// @lc code=end

