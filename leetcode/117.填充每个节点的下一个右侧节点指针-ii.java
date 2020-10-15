import java.util.Queue;

import com.sun.org.apache.bcel.internal.classfile.Node;

/*
 * @lc app=leetcode.cn id=117 lang=java
 *
 * [117] 填充每个节点的下一个右侧节点指针 II
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

class Solution {
    public Node connect(Node root) {
        if( null == root)
            return null;
        //定义一个队列，用于存放所有的节点
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        //当队列不为空时 循环执行
        while(!queue.isEmpty()){
            //用第二层循环表示当前层的节点个数
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();
                if(i < size - 1)
                    cur.next = queue.peek();
                if(cur.left != null)
                    queue.add(cur.left);
                if(cur.right != null)
                    queue.add(cur.right);
            }
        }
        return root;
    }


}
// @lc code=end

