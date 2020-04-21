import java.util.List;

/*
 * @lc app=leetcode.cn id=83 lang=java
 *
 * [83] 删除排序链表中的重复元素
 *
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/description/
 *
 * algorithms
 * Easy (49.77%)
 * Likes:    293
 * Dislikes: 0
 * Total Accepted:    93K
 * Total Submissions: 186K
 * Testcase Example:  '[1,1,2]'
 *
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * 
 * 示例 1:
 * 
 * 输入: 1->1->2
 * 输出: 1->2
 * 
 * 
 * 示例 2:
 * 
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null)
            return null;
        if(head.next == null)
            return head;
        ListNode ans = new ListNode(0);//带头节点的单链表
        ListNode pre = head;//记录前一节点
        ListNode cur = head.next;//记录当前节点
        ListNode pAns = ans;//别称防止丢失
        pAns.next = new ListNode(pre.val);
        pAns = pAns.next;
        while(cur != null)//只要当前不为空继续判断
        {
            //如果当前节点的值和前一节点的值相同，则将当前节点后移，否则当前节点与前一节点都后移
            if(pre.val == cur.val){
                cur = cur.next;
            }else{
                pAns.next = new ListNode(cur.val);
                pAns = pAns.next;
                pre = cur;
                cur = cur.next;
            }
        }
        return ans.next;


        /**
         * 根据题解来看我想的复杂了。。。
         * 直接定义一个cur就行。只要cur  和 cur.next不为空就比较就行
         */



    }
}
// @lc code=end

