/*
 * @lc app=leetcode.cn id=925 lang=java
 *
 * [925] 长按键入
 */

// @lc code=start

/**
 * 基本思路： 用两个指针ij分别指向name和typed，用pre来表示typed的前一个字符
 */
class Solution {
    public boolean isLongPressedName(String name, String typed) {
        // int i=0,j=0;
        // char pre ='+';
        // while(i < name.length() && j < typed.length()){
        //     //如果说两个字符相等的话就直接比较下一个同时要记录一下当前这个字符
        //     if(name.charAt(i) == typed.charAt(j)){
        //         pre = typed.charAt(j);
        //         i++;
        //         j++;
        //     }else{
        //         //如果两个字符不相等的情况
        //         //如果是字符被长按了，那么我们将typed的字符与pre比较，如果一样让他继续向后移动
        //         if(pre == typed.charAt(j)){
        //             j++;
        //         }else{
        //             //如果这个字符和前面的一个字符不同又和要输入的字符不同那么肯定是错误的
        //             return false;
        //         }
        //     }
        // }
    
        // if( i == name.length() && j == typed.length())
        //     return true;
        // while( j < typed.length()){
        //     if(pre != typed.charAt(j))
        //         return false;
        // }
        
        // return false;
        //两个指针 i和j分别指向name和typed
        int i = 0, j = 0;
        //循环的条件只是和typed有关，我们的目的是 先扫描typed
        while (j < typed.length()) {
            //如果说i还在name的长度内标记，并且name和typed此时的字符相等，那么就比较下一个字符
            if (i < name.length() && name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } else if (j > 0 && typed.charAt(j) == typed.charAt(j - 1)) {
                //如果name和typed的字符不相等，就比较typed的前后两个字符注意这里又j-1所以j必须大于0
                // 如果typed当前的值和他的前一个值相等就将j++；
                j++;
            } else {
                //如果说typed的当前字符和name的当前字符不符合并且也不和他的前一个字符一样，那么可以断定false
                return false;
            }
        }
        //当遍历完typed的时候，如果说正确的话i的值也遍历到了name的最后一个
        return i == name.length();
    }
}
// @lc code=end

