/*
 * @lc app=leetcode.cn id=14 lang=java
 *
 * [14] 最长公共前缀
 *
 * https://leetcode-cn.com/problems/longest-common-prefix/description/
 *
 * algorithms
 * Easy (36.79%)
 * Likes:    963
 * Dislikes: 0
 * Total Accepted:    228.4K
 * Total Submissions: 618.4K
 * Testcase Example:  '["flower","flow","flight"]'
 *
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 
 * 如果不存在公共前缀，返回空字符串 ""。
 * 
 * 示例 1:
 * 
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 
 * 
 * 示例 2:
 * 
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 
 * 
 * 说明:
 * 
 * 所有输入只包含小写字母 a-z 。
 * 
 */

// @lc code=start
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0)//当strs为空时
            return "";
        if(strs.length == 1)//当字符串数组只有一个字符串时
            return strs[0];
        int length = strs[0].length();//
        if(length == 0)//如果第一个字符串就为null
            return "";
        for(int i = 1 ; i < strs.length  ; i++){//获取短字符串长度
            if(strs[i].length() == 0)//如果有其他字符串为null
                return "";
            length = Math.min( strs[i].length(), length);
        }
        String ans = "";
        boolean flag = true;//是否相同标志
        for(int i = 0 ; i < length ; i++){
            char temp = strs[0].charAt(i);//获取第一个字符串的第i个字符
            for(int j = 1 ; j < strs.length ; j++){//第2个字符串开始匹配
                if( temp != strs[j].charAt(i))
                    flag = false;
            }
            if(flag)//如果匹配成功
                ans = ans + temp;
            else{
                if(ans.isEmpty())//全部匹配失败
                    return "";
                else
                    return ans;//匹配失败但是有部分已经匹配成功
            }
        }
    }

    /**   
        官方解法2 ，和我的解题思路一样。但是代码十分的简洁
        if (strs == null || strs.length == 0) return "";
            for (int i = 0; i < strs[0].length() ; i++){
        char c = strs[0].charAt(i);
        for (int j = 1; j < strs.length; j ++) {
            if (i == strs[j].length() || strs[j].charAt(i) != c)
                return strs[0].substring(0, i);             
        }
        return strs[0];

     */
}
// @lc code=end

