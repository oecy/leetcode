import java.util.Stack;

/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 *
 * https://leetcode-cn.com/problems/valid-parentheses/description/
 *
 * algorithms
 * Easy (41.31%)
 * Likes:    1518
 * Dislikes: 0
 * Total Accepted:    255.5K
 * Total Submissions: 617.4K
 * Testcase Example:  '"()"'
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 
 * 有效字符串需满足：
 * 
 * 
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 
 * 
 * 注意空字符串可被认为是有效字符串。
 * 
 * 示例 1:
 * 
 * 输入: "()"
 * 输出: true
 * 
 * 
 * 示例 2:
 * 
 * 输入: "()[]{}"
 * 输出: true
 * 
 * 
 * 示例 3:
 * 
 * 输入: "(]"
 * 输出: false
 * 
 * 
 * 示例 4:
 * 
 * 输入: "([)]"
 * 输出: false
 * 
 * 
 * 示例 5:
 * 
 * 输入: "{[]}"
 * 输出: true
 * 
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {
        if(s.isEmpty())//空字符串
            return true;
        char[] str_c = s.toCharArray();
        Stack<Character> stack = new Stack<>();//栈 储存左括号
        for(int i = 0 ; i < str_c.length ; i++){
            if(str_c[i] == '{' || str_c[i] == '(' || str_c[i] == '[')
                stack.push(str_c[i]);
            else{
                if(stack.empty())//如果没有内容入栈 即第一个为右括号
                    return false;
                if(str_c[i] == ')')//括号开始匹配
                    if(stack.pop() != '(')
                        return false;
                if(str_c[i] == ']')
                    if(stack.pop() != '[')
                        return false;
                if(str_c[i] == '}')
                    if(stack.pop() != '{')
                        return false;
            }
        }
        if(!stack.empty()) //匹配结束后如果栈中还有元素，则说明无效
            return false;
        return true;

    }
}
// @lc code=end

