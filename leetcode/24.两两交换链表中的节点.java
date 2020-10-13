import java.util.List;

/*
 * @lc app=leetcode.cn id=24 lang=java
 *
 * [24] 两两交换链表中的节点
 *
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/description/
 *
 * algorithms
 * Medium (66.83%)
 * Likes:    679
 * Dislikes: 0
 * Total Accepted:    169.4K
 * Total Submissions: 250.9K
 * Testcase Example:  '[1,2,3,4]'
 *
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 
 * 
 * 
 * 示例:
 * 
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 * 
 * 
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
  * 10.13
  * 第一次解题思路：如果其后面的节点存在孩子，则递归调用，如果不存在(或是单数个节点)直接新建返回
  *
  * 解后反思：本题目中的要求是不能交换val的值而是要更改指针 并不是说一定要所有的节点都要新建，所以直接交换指针就可以了
  */
class Solution {
    public ListNode swapPairs(ListNode head) {
        //处理节点为空以及单数个节点的最后一个的情况
        if(head == null)
            return null;
        if(head.next == null){
            return new ListNode(head.val);
        }
        //一定存在两个节点的情况

        //先新建一个节点用于存储第二个节点 也就是交换后的第一个节点,然后新建一个节点存储第一个节点值并递归调用交换函数设置自己的next
        return new ListNode(head.next.val,new ListNode(head.val,swapPairs(head.next.next)));
    
        
    }
}
// @lc code=end

