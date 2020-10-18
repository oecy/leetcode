import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=19 lang=java
 *
 * [19] 删除链表的倒数第N个节点
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

 /**
  * n是有效的所以不用考虑越界等无效情况
  */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Map<Integer,ListNode> map = new HashMap<>();
        // int i = 0;
        // ListNode cur = head;
        // while(cur != null){
        //     map.put(i++,cur);
        //     cur = cur.next;
        // }
        // //处理一下特殊情况 头节点要被删除
        // if(i == n){
        //     return head.next;
        // }
        // cur = head;
        // int val = map.get(i-n).val; 
        // //不可以使用val进行判断是否到达已经要删除的节点
        // //对于测试用例[6,3,4,9,0,2,1,6,2,8,1,2,6,3,5,0,7,8,1]这样的情况会存在相同的值
        // //且j要从1开始
        // for (int j = 1; j < i-n; j++) {
        //     cur = cur.next;
        // }
        // cur.next = cur.next.next; 
        // return head;


        /**
         * 看完题解之后的方法双指针法，也是最经典的方法之一
         * 快慢指针，让快慢指针之间相差n个距离，那么当快指针到达尾部时，慢指针就时我们要删除的节点的前一个节点
         * 
         */
        ListNode dummy = new ListNode(0, head);
        ListNode first = head;
        ListNode second = dummy;
        for (int i = 0; i < n; ++i) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        ListNode ans = dummy.next;
        return ans;
         
    }
}
// @lc code=end

