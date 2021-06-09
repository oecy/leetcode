/*
 * @lc app=leetcode.cn id=160 lang=golang
 *
 * [160] 相交链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func getIntersectionNode(headA, headB *ListNode) *ListNode {
	// //这是基础的map解法
    // vis := map[*ListNode]bool{}
    // for tmp := headA; tmp != nil; tmp = tmp.Next {
    //     vis[tmp] = true
    // }
    // for tmp := headB; tmp != nil; tmp = tmp.Next {
    //     if vis[tmp] {
    //         return tmp
    //     }
    // }
    // return nil

	// // 双指针解法
	if headA == nil || headB ==nil {
		return nil
	}
	pa,pb := headA,headB
	for pa != pb {
		if pa == nil {
            pa = headB
        } else {
            pa = pa.Next
        }
        if pb == nil {
            pb = headA
        } else {
            pb = pb.Next
		}
	}
	return pa
}
// @lc code=end

