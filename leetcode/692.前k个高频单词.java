import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=692 lang=java
 *
 * [692] 前K个高频单词
 */

// @lc code=start
class Solution {

    public List<String> topKFrequent(String[] words, int k) {
        /**
         * 思路： 利用hashmap统计出现的次数。然后找出前k大的单词
         */
        Map<String,Integer> map = new HashMap<>();
        for(String s : words){
            map.put(s, map.getOrDefault(s, 0)+1);
        }
        List<String> ans = new ArrayList<>();
        // for(Map.Entry<String, Integer> e : map.entrySet()){
        //     ans.add(e.getKey());
        // }
        // /**
        //  * 学习到了。 进行一个序列排序比较的时候 ，除了可以用自身大小之外
        //  * 还可以通过新建的比较器接口进行实现。
        //  * 例如 本题目中的 比较器可以使用map.get(word)比较他们出现的次数。
        //  * 而且String.compareTo（）这个方法可以比较两个字符串的在unicode上出现的先后次序
        //  */
        // Collections.sort(ans, new Comparator<String>(){
        //     public int compare(String word1,String word2){
        //          return map.get(word1) == map.get(word2) ? word1.compareTo(word2) : map.get(word2) - map.get(word1);
        //     }
        // });
        // return ans.subList(0, k);

        //以下是优先队列的解法
        /**
         * 使用有优先队列的时候 一定要有一个比较器的接口。
         * 优先队列是从 jdk1.5开始实现的一个工具。其实现是一个二叉小顶堆
         */
        PriorityQueue<Map.Entry<String,Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<String,Integer>>(){
            public int compare(Map.Entry<String,Integer> e1,Map.Entry<String,Integer>e2){
                return e1.getValue() == e2.getValue() ? e2.getKey().compareTo(e1.getKey()) : e1.getValue() - e2.getValue();
            }
        });

        for(Map.Entry<String, Integer> e : map.entrySet()){
            pq.offer(e);
            if(pq.size() > k){
                pq.poll();
            }
        }

        while(!pq.isEmpty()){
            ans.add(pq.poll().getKey());
        }
        Collections.reverse(ans);
        return ans;
    }
}
// @lc code=end

