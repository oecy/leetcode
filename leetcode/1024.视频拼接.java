import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1024 lang=java
 *
 * [1024] 视频拼接
 */

// @lc code=start


/**
 * 思路：
 * 
 */
class Solution {
    public int videoStitching(int[][] clips, int T) {
        // //定义一个数组，标记每一个开始片段对应的结束时间
        // int[] arr = new int[T];
        // //初始化arr
        // for(int[] clip : clips){
        //     //开始时间一定要在这个时间片段内
        //     if(clip[0] < T)
        //         //保证如果有相同起点的区间取到最大值
        //         arr[clip[0]] = Math.max(clip[1], arr[clip[0]]);
        // }

        // //贪心算法
        // //last表示当前可以达到的最远的距离
        // //ret记录次数
        // //pre记录上一个最远区间的最右侧断电
        // int last = 0,ret = 0,pre = 0;
        // for(int i=0 ; i < T ; i++){
        //     last = Math.max(last, arr[i]);
        //     if(i == last){
        //         return -1;
        //     }
        //     if(i == pre){
        //         ret++;
        //         pre = last;
        //     }
        // }
        // return ret;


        //第二种解法，动态规划
        //思路： 由题意可知，因为我们拥有的是一系列的片段，他们都是一个个的时间区间
        // 那么对于一个时间区间 假设为[4,10]而言，想要他的片段数最少，那么就需要
        // 从4开始到9这个位置，只要由一条片段序列可以达到这4-9之中就说明我们可以进行剪辑
        // 剪辑的次数就是 剪辑到4 一直剪辑到9的 次数最小值 在加上这个片段 生成剪辑到10的最小片段数

        //就一般性而言，一个视频片段的最小的片段数假设其区间为[i,j]
        //那么其 dp[j]  = min{dp[k] + 1} k为从i到j-1


        //一般而言动态规划的算法都会多出与1个元素，用来存储最终结果
        int[] dp = new int[T+1];
        //填充所有的dp，默认认为其需要的片段个数为无限大，因为没有数据进来就意味着没有可以完成覆盖T的序列
        Arrays.fill(dp, Integer.MAX_VALUE - 1);
        
        //dp[0] = 0  设置dp[0] = 0因为无论怎么，从自己到自己不需要剪辑
        dp[0] = 0;
        //最外层循环，就是T的每一分钟都遍历一下
        for(int i = 0 ; i <= T ; i++){
            //内层循环，对于每一个clip而言要进行一次更新
            for(int[] clip : clips){
                //
                if (clip[0] < i && i <= clip[1]) {
                    dp[i] = Math.min(dp[i], dp[clip[0]] + 1);
                }
            }

        }
        return dp[T] == Integer.MAX_VALUE - 1 ? -1 : dp[T];
    }
}
// @lc code=end

