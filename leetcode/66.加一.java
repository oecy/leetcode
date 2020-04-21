/*
 * @lc app=leetcode.cn id=66 lang=java
 *
 * [66] 加一
 *
 * https://leetcode-cn.com/problems/plus-one/description/
 *
 * algorithms
 * Easy (43.71%)
 * Likes:    459
 * Dislikes: 0
 * Total Accepted:    144.6K
 * Total Submissions: 329K
 * Testcase Example:  '[1,2,3]'
 *
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * 
 * 示例 1:
 * 
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 
 * 
 * 示例 2:
 * 
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 * 
 * 
 */

// @lc code=start
class Solution {
    //题目已经说了非空正整数数组，所以不存在为空的特殊情况也不存在溢出或者负数的情况
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        int cf = digits[len-1] + 1 > 9 ? 1 : 0;//先计算是否有进位，下一步会改变digits的值再计算会出错
        digits[len-1] = (digits[len-1] + 1) % 10;
 
        //从最低位开始计算
        for(int i = digits.length - 2 ; i >= 0 ; --i){//慢慢计算
            int temp  = digits[i];//记录一下当前digits[i]的值
            digits[i] = (digits[i] + cf ) % 10;
            cf = temp + cf > 9 ? 1 : 0;//计算进位 使用先前记录的temp 因为 当前的digits已经被改变了
            
        }
        if(cf == 0)//如果最高位没有进位
            return digits;
        //对于将数组增加一位的操作 特别精彩！！！
        digits = new int[len+1];
        digits[0] = 1;
        return digits;
        /**
         * 看完题解发现有一个特别精彩的解法。
         * 由题可知 加一一共有两种情况 一种是9，加1进位还有一种是非9加1返回
         * 如果非9加1 之后直接判断取余后是否为0 为0 则返回
         * 如果为9 取余后为0，继续循环下一位继续 ++ 重复操作。
         * 如果全部是9会有高位溢出，那么就是上面的方法，因为这个溢出只可能是1.
         */

    }
}
// @lc code=end

