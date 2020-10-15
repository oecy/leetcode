import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

import com.sun.corba.se.impl.orbutil.graph.Node;

/*
 * @lc app=leetcode.cn id=116 lang=java
 *
 * [116] 填充每个节点的下一个右侧节点指针
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

/**
 * 10.15每日一题  
 * 解题思路：因为这个next节点主要是指向同一层的节点，所以可以使用层序遍历来实现
 * 先通过层序遍历将所有层的节点链接，然后将所有右子树及其右孩子的next设置为null
 */
class Solution {
    public Node connect(Node root) {
        if( null == root)
            return null;
        //定义一个队列，用于存放所有的节点
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        // //当队列不为空时 循环执行
        // while(!queue.isEmpty()){
        //     //取出当前队列的头节点
        //     Node cur = queue.poll();

        //     //如果队列不为空将队列中的下一个节点设置为他的next
        //     //这里不用判断是因为peek方法如果队列为空peek() 返回 null
        //     cur.next = queue.peek();
        //     if(cur.left != null)
        //         queue.add(cur.left);
        //     if(cur.right != null)
        //         queue.add(cur.right);
        // }
        // setRightNull(root);

        // return root;


        //一个改进:每一层都用一个循环来进行标记
        while(!queue.isEmpty()){
            //获得当前层的节点个数
            int size = queue.size();
            for (int i = 0; i < size ; i++) {
                //当前节点
                Node cur = queue.poll();
                //如果不是当前层的最后一个节点那么就链接
                if( i < size - 1 ){
                    cur.next = queue.peek();
                }
                if(cur.left != null)
                    queue.add(cur.left);
                if(cur.right != null)
                    queue.add(cur.right);
            }
        }


        // 官方解法2： 利用了一个head指针来标记上一层的序列 
        // if (root == null) {
        //     return root;
        // }
        
        // // 从根节点开始
        // Node leftmost = root;
        
        // //之所以只判断左孩子是因为他是一个完全二叉树，过于完美所以可以有简单解法
        // while (leftmost.left != null) {
            
        //     // 遍历这一层节点组织成的链表，为下一层的节点更新 next 指针
        //     // 主要用来标记这一层的
        //     Node head = leftmost;
            
        //     //上一层还没有遍历结束
        //     while (head != null) {
                
        //         // 因为是完全二叉树所以必然有左右孩子，直接连接
        //         head.left.next = head.right;
                
        //         // 当这一层还有节点时，即上一层左边节点的右孩子和右边节点的左孩子连接
        //         if (head.next != null) {
        //             head.right.next = head.next.left;
        //         }
                
        //         // 指针向后移动（上一层）
        //         head = head.next;
        //     }
            
        //     // 去下一层的最左的节点
        //     leftmost = leftmost.left;
        // }
        return root;

    }


    //设置最右侧的节点的next为null
    // public void setRightNull(Node root){
    //     if(root == null)
    //         return;
    //     root.next = null; 
    //     setRightNull(root.right);
    // }
}
// @lc code=end

