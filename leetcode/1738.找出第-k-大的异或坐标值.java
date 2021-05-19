import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1738 lang=java
 *
 * [1738] 找出第 K 大的异或坐标值
 */

// @lc code=start
/**
 * 计算第k大
 */
class Solution {
    public int kthLargestValue(int[][] matrix, int k) {

        int m = matrix.length;
        int n = matrix[0].length;
        // 看了一眼提示。 用前缀和。暂时没什么思路
        /**
         * 一开始题目没读懂。现在重新看了一遍题目，思路如下 坐标就是所有该坐标左上角的矩阵得到所有值的异或和。然后找到第k大的数
         */

        /**
         * 建立一个二维数组计算所有的前缀和.s[0][0] = 0因为其左上角没有元素 且 m[0][0]对自身异或结果也是0. 对于其他位置的元素。
         * s[i][j] = s[i-1][j-1] ^ m[i][j] ^ s[i-1][j] ^ s[i][j-1] 最后两个是指 处理ij
         * 的同行与同列的异或和，然后又因为都包含了 s[i-1][j-1] 异或为0 所以加上它，再与m[i][j]异或 注意边界的情况
         * 写到一半想到的优化，每计算一个前缀和就加入到一个大小为k的升序数组里 然后进行比较大小。这样计算结束后，数组的第一位就是我们要求的第k大。 tip:
         * 这个优化其实是负优化，这样每次排序不如最后再排序
         */
        // int[] ans = new int[k];
        // int count = 0;//记录数组里有多少个数了
        List<Integer> list = new ArrayList<>();
        int[][] s = new int[m + 1][n + 1];
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                s[i][j] = s[i - 1][j - 1] ^ s[i - 1][j] ^ s[i][j - 1] ^ matrix[i - 1][j - 1];
                list.add(s[i][j]);
                // //处理前缀和
                // if(count < k){
                // ans[count] =s[i][j];
                // count++;
                // }else{
                // //重新排序
                // Arrays.sort(ans);
                // if(s[i][j] > ans[0]){
                // ans[0] = s[i][j];
                // }
                // }

            }
        }

        // 对list排序。
        Collections.sort(list, new Comparator<Integer>() {
            public int compare(Integer num1, Integer num2) {
                return num2 - num1;
            }
        });

        return list.get(k - 1);
        // Arrays.sort(ans);
        // return ans[0];
    }

}
// @lc code=end
