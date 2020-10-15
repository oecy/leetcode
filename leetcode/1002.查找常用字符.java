import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1002 lang=java
 *
 * [1002] 查找常用字符
 */

// @lc code=start

/**
 * 10.14每日一题  
 * 解题思路：因为题目中已经说了所有的字符都是小写字母，而小写字母一共只有26个，所以用两个数组来判定
 * 又题目中要求我们需要的字符是每个字符串中都有，所以我们选择第一个字符串中字符个数作为参考
 * 第一个数组用来标记每个元素是否在每个字符串中都出现了一次
 * 第二个数组用来标记每个字符串里每个字符的个数然后取所有字符串的最大值
 */
class Solution {
    public List<String> commonChars(String[] A) {
        if(A.length == 0){
            return null;
        }
        // //map用于存储这些可能输出字符的次数
        // Map<Character,Integer> map = new HashMap<>();

        // //一个新的map用于存储每一轮次中的最大出现次数
        // Map<Character,Integer> countMap = new HashMap<>();
        // for(int i = 0 ; i < A[0].length() ; i++){
        //     if(map.containsKey(A[0].charAt(i))){
        //         map.put(A[0].charAt(i), map.get(A[0].charAt(i)));
        //     }
        //     else{
        //         map.put(A[0].charAt(i), 1);
        //         countMap.put(A[0].charAt(i), 0);
        //     }
        // }
        // for (int i = 1; i < A.length; i++) {
        //     for(int j = 0 ; j < A[i].length() ; j++){
        //         //如果String中的字符在map中没有出现过那么我们直接将这个字符舍弃掉
        //         if(!countMap.containsKey(A[i].charAt(j))){
                    
        //         }else{
        //             //将出现次数进行存储，如果出现次数为0则将之删除
        //             countMap.put(A[i].charAt(j), countMap.get(A[i].charAt(j))+1);
        //         }
        //         //处理完最后一个字符后进行处理
        //         //1是将没出现的字符删除  2 是更新一下出现字符出现的最大次数
        //         if( j == A[i].length() - 1 ){
        //             //如果值为0说明这个元素在新的数组中没有出现过那么就将他删除
        //             Collection<Integer> collect = countMap.values();
        //             while(collect.contains(0) == true){
        //                 collect.remove(0);
        //             }
        //             //更新一下全局最大值
        //             for(Character c : countMap.keySet()){
        //                 map.put(c, Math.max(map.get(c), countMap.get(c)));
        //             }
        //         }
        //     }
        // }
    
        //  //将map输入list
        //  List<String> list = new ArrayList<>();
        //  for(Character c : map.keySet()){
        //      for(int i = 0 ; i < map.get(c); i++){
        //         list.add(String.valueOf(c));
        //      }

        //  }
        //  return list;

        //计数 记录所有可能出现数字的最大出现次数
        int[] minfreq = new int[26];
        //填充最大值
        Arrays.fill(minfreq, Integer.MAX_VALUE);
        //对每一个字符串而言
        for (String word: A) {
            //新建一个数组表示当前字符串中所有字符出现的次数
            int[] freq = new int[26];
            //当前字符串的长度
            int length = word.length();
            //获得每一个字符，并将他们的出现次数进行更新
            for (int i = 0; i < length; ++i) {
                char ch = word.charAt(i);
                ++freq[ch - 'a'];
            }
            //每一个字符串的所有字符遍历之后和全局可能的最大出现次数取小
            for (int i = 0; i < 26; ++i) {
                minfreq[i] = Math.min(minfreq[i], freq[i]);
            }
        }
        //构建结果list
        List<String> ans = new ArrayList<String>();
        for (int i = 0; i < 26; ++i) {
            for (int j = 0; j < minfreq[i]; ++j) {
                ans.add(String.valueOf((char) (i + 'a')));
            }
        }
        return ans;  
    }
}
// @lc code=end

