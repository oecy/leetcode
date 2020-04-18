/*
 * @lc app=leetcode.cn id=21 lang=java
 *
 * [21] 合并两个有序链表
 *
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/description/
 *
 * algorithms
 * Easy (60.78%)
 * Likes:    960
 * Dislikes: 0
 * Total Accepted:    231.2K
 * Total Submissions: 378.5K
 * Testcase Example:  '[1,2,4]\n[1,3,4]'
 *
 * 将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * 
 * 示例：
 * 
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null )//有一个链表为空时直接返回
            return l2;
        if(l2 == null )
            return l1;
        ListNode ans = new ListNode(0);//带头节点的 单链表 
        ListNode ln = ans;//链表别称，防止返回时丢失
        while( l1 != null &&  l2 != null){ //如果不为空，则进行比较,小的加在节点后
            if(l1.val > l2.val){
                ln.next = l2;
                l2 = l2.next;
                ln = ln.next;
            }else{
                ln.next = l1;
                l1 = l1.next;
                ln = ln.next;
            }   
        }
        if(l1 == null ){//如果为空 则将不为空的链表直接加在ln之后返回。
            ln.next = l2;
            return ans.next;
        }
        else{
            ln.next = l1;
            return ans.next;
        }

    }
}
// @lc code=end

