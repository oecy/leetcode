/*
 * @lc app=leetcode.cn id=11 lang=java
 *
 * [11] 盛最多水的容器
 */

// @lc code=start

/**
 * 10.13 装水最多要考虑两个问题，一个是两个点之间的距离（横坐标）
 *       另一个是两个点纵坐标对应的高度差
 */
class Solution {

    //结果变量
    int ans = 0; 
    public int maxArea(int[] height) {
        //从第二个元素开始遍历
        // for (int i = 1; i < height.length; i++) {
        //     //逐一与当前元素之前的所有元素进行比较
        //     for (int j = 0; j < i; j++) {
        //         ans = Math.max(ans, Math.min(height[i], height[j]) * ( i - j ));
        //     }
        // }
        // return ans;


        // 第二次解法 双指针！！！太精彩了！！！

        //注意双指针法的证明：为什么移动短边可以保证舍去不可能最大的情况
        /**
         * S = 两点的小值  *  两点距离。
         * 当将两边设置为0和length-1时，即保证了当高度为两者最小时可以达到的最大面积
         * 那么将矮的那一边向里移动（两点距离肯定变小）可能会有以下几种情况
         * 1、新的边比之前的边矮，面积减小
         * 2、新的边和原来的矮边一样高、面积减小
         * 3、新的边比原来的矮边高，面积可能变大
         * 我们这样就可以舍去12这两种情况去寻找3这个情况
         * 
         * 如果将高的边进行移动会有以下情况
         * 因为其能装的水由短边进行决定所以我们能确定他的面积必然时减小的。所以这种方法舍弃
         */

         /**
          * 看了一下其他人的解答，还存在优化空间
          * 我们知道其大小由边长和两边距离决定，我们可以定义一个变量来存储当前的矮边是多少
          * 那么我们将矮边进行移动的时候不需要每次都计算一下面积。
          * 如果新的边比这个矮边还要矮那么直接舍弃就好
          */
        int left = 0,right = height.length - 1;
        while(left < right){
            ans = Math.max(ans, (right - left) * Math.min(height[left], height[right]));
            if(height[left] < height[right])
                left++;
            else    
                right--;
        }

        return ans;
    }
}
// @lc code=end

