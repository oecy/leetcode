import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=763 lang=java
 *
 * [763] 划分字母区间
 */

// @lc code=start


/**
 *  大概思路：
 *  从头开始遍历，当遇到之前没出现过的字符时，将他单独分为一组，如果是已经出现过的字符，就根据他
 *  是在哪一组里出现的，如果是最靠近他的一组，那么就直接合并，如果中间隔着其他组那么中间的这些组也要进行合并
 *  
 *  这种方法不好是实现
 * 
 *  或者遍历的时候直接找到这个字符最后一次出现的位置，然后依次更新最后出现的位置，如果两个指针相同说明这是一个分割
 *  这种方法就是双指针加贪心算法
 */
class Solution {
    public List<Integer> partitionLabels(String S) {
        //结果list
        List<Integer> res = new ArrayList<>();
        //特殊情况的处理
        if (S.length() == 0) return res;
        //注意到当确定字符为小写字母时，那么其可能的取值就已经固定了一共只有26个，用一个数组记录他们最后出现的位置
        int[] last = new int[26];
        char[] sarr = S.toCharArray();
        for (int i = 0; i < sarr.length; i++) {
           last[sarr[i] - 'a'] = i;
        }
        //从头开始进行遍历，一开始start和end都为0 start为当前划分的头位置，end为尾位置
        int start=0,end=0;
        //如果没有遍历结束就循环
        for (int i = 0; i < sarr.length; i++) {
            //当前划分的结尾位置是当前结尾位置和这个划分之中所有元素的结尾的最大值
            end = Math.max(end, last[sarr[i]-'a']);
            //如果start遍历到了这个划分的最后一个元素
            if(i == end){
                res.add(end - start +1);
                start = end + 1;
            }
        }

       
        return res;
        
    }
}
// @lc code=end

