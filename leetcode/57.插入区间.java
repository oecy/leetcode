import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=57 lang=java
 *
 * [57] 插入区间
 */

// @lc code=start

/**
 * 思路： 
 *     因为已给的区间已经按照起点排序且并不重复，所以对于新区间会有以下几种情况
 *     设区间为[left，right]
 *     1、当 left > interval[1] 即新区间的起点比已有区间的右端点大，那么这个区间不重叠直接加入结果
 *     2、当 right < interval[0] 即新区间的终点比当前区间的左端点小，就说明这个区间及以后的区间都不重叠直接加入结果
 *     3、剩下的情况就是肯定有重叠
 */
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        //结果list
        List<int[]> res = new ArrayList<>();
        //从头开始遍历
        int i = 0;
        //如果说还在已有区间列表内，且新区间的起点比右端点的大，则将这些区间加入结果，要插入的区间肯定在这些区间的右边
        while (i < intervals.length && newInterval[0] > intervals[i][1]) {
            res.add(intervals[i]);
            i++;
        }
        //因为新区间的起点比遍历到区间的右端点小，那么说明必有重复，先将新区间的信息保存
        int[] tmp = new int[]{newInterval[0], newInterval[1]};
        //开始有重叠，并且直到新区间的右端点比遍历区间的左端点小（就是右边的全部不重复了）
        while (i < intervals.length && newInterval[1] >= intervals[i][0]) {
            //要加入结果区间的左端点，取新区间和遍历到的区间的左端点中小的
            tmp[0] = Math.min(tmp[0], intervals[i][0]);
            //要加入结果区间的右端点，取新区间和遍历到的区间的右端点中大的                                        
            tmp[1] = Math.max(tmp[1], intervals[i][1]);
            i++;
        }
        //将这个自己创建的新区间，加入结果
        res.add(tmp);
        //如果原区间没有遍历完，将剩下的继续加入结果
        while (i < intervals.length) {
            res.add(intervals[i]);
            i++;
        }
        return res.toArray(new int[0][]);
    }
}
// @lc code=end
