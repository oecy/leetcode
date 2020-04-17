/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
 *
 * https://leetcode-cn.com/problems/add-two-numbers/description/
 *
 * algorithms
 * Medium (37.03%)
 * Likes:    4166
 * Dislikes: 0
 * Total Accepted:    384.3K
 * Total Submissions: 1M
 * Testcase Example:  '[2,4,3]\n[5,6,4]'
 *
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 
 * 示例：
 * 
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * 
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //使用带头节点的单链表
        ListNode answer = new ListNode(0);
        ListNode ln = answer;//记录下头节点，防止遍历操作时丢失
        int cf = 0;//进位标志
        //处理链表前n个等长节点
        while(l1 != null && l2 != null){
            ln.next = new ListNode((l1.val + l2.val + cf) % 10);
            cf = (l1.val + l2.val + cf) / 10;
            l1 = l1.next;
            l2 = l2.next;
            ln = ln.next;
        }
        //当两链表长度不一样时处理
        while(l1 != null){
            ln.next = new ListNode( (l1.val + cf) % 10);
            cf = (l1.val + cf) / 10;
            l1 = l1.next;
            ln = ln.next;
        }
        while(l2 != null){
            ln.next = new ListNode( (l2.val + cf) % 10);
            cf = (l2.val + cf) / 10;
            l2 = l2.next;
            ln = ln.next;
        }
        //如果最后一位处理结束，但结果仍然有进位
        if(cf > 0 ){
            ln.next = new ListNode(cf);
        }
        return answer.next;
    }
}
// @lc code=end

