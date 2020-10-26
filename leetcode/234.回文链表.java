import java.util.Stack;

/*
 * @lc app=leetcode.cn id=234 lang=java
 *
 * [234] 回文链表
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

 /**
  * 基本思路：
    遍历整个链表并放入一个栈中，然后依次比较

    第二个思路，快慢指针找到中间节点，然后从中间节点开始比较
    这种方法需要将前半段或者后半段的链表进行逆置
  */
class Solution {
    public boolean isPalindrome(ListNode head) {

        Stack<ListNode> stack = new Stack<>();

        ListNode tHead = head;
        while(head != null){
            stack.push(head);
            head = head.next;
        }
        head = tHead;
        while(!stack.isEmpty() && head != null){
            ListNode cur = stack.pop();
            if(cur.val != head.val){
                return false;
            }
            head = head.next;
        }
        return true;
    }
}
// @lc code=end

