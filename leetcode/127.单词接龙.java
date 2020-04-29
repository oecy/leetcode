import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=127 lang=java
 *
 * [127] 单词接龙
 *
 * https://leetcode-cn.com/problems/word-ladder/description/
 *
 * algorithms
 * Medium (40.86%)
 * Likes:    282
 * Dislikes: 0
 * Total Accepted:    34.5K
 * Total Submissions: 83.8K
 * Testcase Example:  '"hit"\n"cog"\n["hot","dot","dog","lot","log","cog"]'
 *
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord
 * 的最短转换序列的长度。转换需遵循如下规则：
 * 
 * 
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 
 * 
 * 说明:
 * 
 * 
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * 
 * 
 * 示例 1:
 * 
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * 
 * 输出: 5
 * 
 * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * ⁠    返回它的长度 5。
 * 
 * 
 * 示例 2:
 * 
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * 
 * 输出: 0
 * 
 * 解释: endWord "cog" 不在字典中，所以无法进行转换。
 * 
 */

// @lc code=start
class Solution {
    //如果使用深度优先算法，因为要求最短的转换序列所以每次必然都会访问所有节点。故而会超时
    //可以将其理解成一颗树。其中startWorld是根节点，而其子节点则是更改一个字符后的单词
    //双端BFS算法 更快
    //因为题目已经说了非空 不需要进行特殊情况的处理
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        int end = wordList.indexOf(endWord);
        if(end == -1)//如果单词表不含有endWord直接返回
            return 0;

        wordList.add(beginWord);//将开始节点也放入其中
        int start = wordList.size() - 1;

        Queue<Integer> queue1 = new LinkedList<>();//辅助队列1用于正向遍历
        Queue<Integer> queue2 = new LinkedList<>();//辅助队列2用于反向遍历
        
        Set<Integer> visited1 = new HashSet<>();//已访问set正向 访问标记
        Set<Integer> visited2 = new HashSet<>();//已访问set反向 访问标记

        //初始化队列与访问标记
        queue1.add(start);
        visited1.add(start);
        queue2.add(end);
        visited2.add(end);

        int count = 0;//深度计数
        while(!queue1.isEmpty() && !queue2.isEmpty()){//正向且反向访问队列不为空
            ++count;
            //优化  每次搜索总是从结果少的那一边搜索  加快执行速度
            if(queue1.size() > queue2.size()){
                Queue<Integer> tempQueue = queue1;
                queue1 = queue2;
                queue2 = tempQueue;
                Set<Integer> tempSet = visited1;
                visited1 = visited2;
                visited2 = tempSet;
            }
            int size = queue1.size();
            while(size --> 0){//当size不为0时  等于  for(int i = 0; i<size ; ++i)
                String s = wordList.get(queue1.poll());//获取到当前的字符串
                for(int i = 0  ; i < wordList.size() ; ++i){
                    if(visited1.contains(i))//如果已经访问过了，处理下一个
                        continue;
                    if(!canChange(s, wordList.get(i)))//如果不能进行转换 下一个
                        continue;
                    if(visited2.contains(i))//如果正确匹配。返回深度
                        return count + 1;
                    //如果匹配不成功的话,将之入队，并且将访问标记入队
                    visited1.add(i);
                    queue1.add(i);
                }
            }
        }
        return 0;
    }

    boolean canChange(String s,String t){
        int len = s.length();
        int flag = 0;
        for(int i = 0 ; i < len ; ++i){
            if(s.charAt(i) != t.charAt(i)) 
                ++flag;
        }
        return flag == 1;
    }
}
// @lc code=end

