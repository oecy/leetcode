import java.util.List;

/*
 * @lc app=leetcode.cn id=160 lang=java
 *
 * [160] 相交链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
/**
 * 注意点。这里题目给的示例太具有迷惑性了。
 * 相交的起始节点不能单纯的比较val的大小。除了val大小相同之外，地址也需要相同。且这个val不能是0
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        /**
         * 基本思路：因为相交的话必然会是最后的一些节点相交，
         * 先计算每一个链表的长度，然后从较短的那一个开始遍历 
         */
        /**
         * 用hashmap就不写了
         * 双指针法：即总共需要遍历的长度是 len(A)+len(b)。无论怎么遍历。如果有相同的
         * 节点，那么 这两个指针其需要遍历的总长度不变，那么必然会遍历到相同的节点，或者遍历到最后。
         * 
         */
        //只要有一个为null 就返回null
        if(headA == null || headB == null)
            return null;
        ListNode pA = headA, pB = headB;
        while(pA != pB){
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;

    }


}
// @lc code=end

