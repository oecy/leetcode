import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=52 lang=java
 *
 * [52] N皇后 II
 */

// @lc code=start

/**
 * 10.17
 * 解题思路：皇后的攻击范围同一行、同一列、同一斜线
 * 通过递归来实现，尝试第一行的每一个位置放置第一个皇后，然后递归到第二行将尝试找到第二个皇后所在的位置
 * 然后对于斜线的处理
 * 1、左上到右下这一条斜线他的xy的坐标差是固定的
 * 2、左下到右上这已斜线他的xy的坐标和是固定的
 */
class Solution {
    public int totalNQueens(int n) {
        //记录 哪一列已经有皇后了
        Set<Integer> col = new HashSet<>();
        //记录左上到右下的斜线
        Set<Integer> d1 = new HashSet<>();
        //记录左下到右上的斜线
        Set<Integer> d2 = new HashSet<>();

        return traceBack(n, 0, col, d1, d2);

    }

    /**
     * 注意为什么使用 回溯的时候不使用全局的set因为回溯
     * @param n          一共多少个皇后
     * @param row        当前是第几行
     * @param col        哪几列已经使用了
     * @param d1         哪几个斜线已经使用了
     * @param d2         哪几个斜线2已经使用了
     * @return 本次回溯找到的可能解的个数
     */
    public int traceBack(int n, int row,Set<Integer> col,Set<Integer> d1,Set<Integer> d2){
        //已经到达了最后一行那么说明必然只有一种结果了
        if( n == row ){
            return 1;
        }else{
            //定义这一行一共可能有多少个结果
            int count = 0;
            //从第一列开始计算，每一列是否已经有数了
            for (int i = 0; i < n; i++) {
                //如果这一列已经有皇后了，那么直接将跳出本次循环进行下一次循环
                if(  col.contains(i)){
                    continue;
                }
                //如果左上到右下的这一条斜线也有数了跳过
                int dd1 = row - i;
                if( d1.contains(dd1)){
                    continue;
                }
                //如果左下到右上的斜线也有皇后了跳过
                int dd2 = row + i;
                if(d2.contains(dd2)){
                    continue;
                }
                //如果都没有的话就将这个位置添加到3个set中
                d1.add(dd1);
                d2.add(dd2);
                col.add(i);

                //向下一层进行递归并计算可能存在解的个数
                count += traceBack(n, row+1, col, d1, d2);

                //这一次的回溯结束之后要将这一次回溯产生的占用删除
                d1.remove(dd1);
                d2.remove(dd2);
                col.remove(i);

            }

            //这一层的回溯结束返回可能的解的个数
            return count;
        }
    }
}
// @lc code=end

