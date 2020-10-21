import java.util.Stack;

/*
 * @lc app=leetcode.cn id=143 lang=java
 *
 * [143] 重排链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if(head==null || head.next==null || head.next.next==null)return;

    // 1. 找中点，让slow指向中点，或左中点位置
    ListNode slow = head, fast = head.next;
    while (fast!=null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }

    // 2. 断开中点，反转后半部分
    ListNode head2 = null, next = slow.next;
    slow.next = null;
    slow = next;
    while(slow != null) {
        next = slow.next;
        slow.next = head2;
        head2 = slow;
        slow = next;
    }

    // 3. 合并链表head和head2
    ListNode curr = head;
    ListNode curr2 = head2;
    while(curr != null && curr2!=null) {
        next = curr.next;
        curr.next = curr2;
        curr2 = curr2.next;
        curr.next.next = next;
        curr = next;
    }
    }
}
// @lc code=end

