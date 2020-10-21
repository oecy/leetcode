import java.util.Stack;

/*
 * @lc app=leetcode.cn id=844 lang=java
 *
 * [844] 比较含退格的字符串
 */

// @lc code=start

/**
 * 基本思路用两个栈分别存储这两个字符串的所有字符。然后比较两个栈的元素
 */
class Solution {
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> stackS = new Stack<>();
        Stack<Character> stackT = new Stack<>();
        for(int i = 0 ; i < S.length() ; i++){
            if(S.charAt(i) == '#'){
                if(!stackS.isEmpty()){
                    stackS.pop();
                }
            }else{
                stackS.push(S.charAt(i));
            }
        }
        for(int i = 0 ; i < T.length() ; i++){
            if(T.charAt(i) == '#'){
                if(!stackT.empty()){
                    stackT.pop();
                }
            }else{
                stackT.push(T.charAt(i));
            }
        }
        
        //当两个栈都不为空的时候
        while(!stackS.isEmpty() && !stackT.isEmpty()){
            if(!stackS.pop().equals(stackT.pop())){
                return false;
            }
        }
        if(stackS.isEmpty() && stackT.isEmpty())
            return true;
        //有一个栈为空返回false
        if(stackS.isEmpty() || stackT.isEmpty())
            return false;
        return true;
        
    }
}
// @lc code=end

