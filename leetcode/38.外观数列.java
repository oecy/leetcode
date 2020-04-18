import java.util.Stack;

/*
 * @lc app=leetcode.cn id=38 lang=java
 *
 * [38] 外观数列
 *
 * https://leetcode-cn.com/problems/count-and-say/description/
 *
 * algorithms
 * Easy (54.76%)
 * Likes:    449
 * Dislikes: 0
 * Total Accepted:    88.9K
 * Total Submissions: 161.9K
 * Testcase Example:  '1'
 *
 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。前五项如下：
 * 
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 6.     312211
 * 
 * 
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 * 
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出外观数列的第 n 项。
 * 
 * 注意：整数序列中的每一项将表示为一个字符串。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 输入: 1
 * 输出: "1"
 * 解释：这是一个基本样例。
 * 
 * 示例 2:
 * 
 * 输入: 4
 * 输出: "1211"
 * 解释：当 n = 3 时，序列是 "21"，其中我们有 "2" 和 "1" 两组，"2" 可以读作 "12"，也就是出现频次 = 1 而 值 =
 * 2；类似 "1" 可以读作 "11"。所以答案是 "12" 和 "11" 组合在一起，也就是 "1211"。
 * 
 */

// @lc code=start
class Solution {
    public String countAndSay(int n) {
        StringBuilder ans = new StringBuilder();//StringBuilder 内部使用char数组实现，所以效率很高
        ans.append("1");//n = 1时
        for (int i = 2; i <= n ; i++) {
            //遍历前一个字符串
            String currentStr = new String(ans);
            //删除前一个字符串在ans中的内容
            ans.delete(0,ans.length());
            int count = 0;//计数 因为第一个字符必定匹配所以设置为0 必然+1
            char currentChar = currentStr.charAt(0);//当前的字符串的第一个字符
            for (char c : currentStr.toCharArray()) {//遍历字符串
                if(c == currentChar){//如果字符匹配就计数+1
                    count++;
                }
                else{//如果不匹配则将计数和当前的字符存入ans中
                    ans.append((char)('0'+count));//int 转成了 char
                    ans.append(currentChar);
                    currentChar = c;
                    count = 1;//计数归1
                }
            }
            ans.append((char)('0'+count));//最后一个字符的处理**
            ans.append(currentChar);

        }

        return ans.toString();
    }
}
// @lc code=end

