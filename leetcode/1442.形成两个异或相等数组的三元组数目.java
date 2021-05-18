import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1442 lang=java
 *
 * [1442] 形成两个异或相等数组的三元组数目
 */

// @lc code=start
/**
 * 初始思路就对j循环，然后通过i，k计算ab。 然后计算次数返回结果。但部分示例输出不对
 * 之后看了题解。精彩。
 * 本题主要思路：前缀和，异或，还有看评论里的解法，求字串异或和为0即可，与j无关。
 *                     a==b实际上就是a^b==0
 */
class Solution {
    public int countTriplets(int[] arr) {
        int ans = 0,s=0;
        //前缀和 一遍循环 牛逼的
        int len = arr.length;
        //int[] s = new int[len+1];
        Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
        Map<Integer, Integer> total = new HashMap<Integer, Integer>();
        for (int k = 0; k < len; k++) {
            int val = arr[k];
            if (cnt.containsKey(s ^ val)) {
                ans += cnt.get(s ^ val) * k - total.get(s ^ val);
            }
            cnt.put(s, cnt.getOrDefault(s, 0) + 1);
            total.put(s, total.getOrDefault(s, 0) + k);
            s ^= val;
        }
        
        // //三重循环  超时 时间复杂度：O(n^3) 空间复杂度：O(n)
        // for (int i = 0; i < len; i++) {
        //     for (int j = i+1; j < len; j++) {
        //         for (int k = j; k < len; j++) {
        //             if(s[i] == s[k+1])
        //                 ans++;
        //         }
        //     }
        // }

        //两重循环，通过三重循环发现其实题目中的j没什么作用的 如果s[i] == s[k+1]
        // 可能的j的个数就是k-i，i~k中的任意一个值都行，除了i本身。所以个数为k-i
        // for (int i = 0; i < len; i++) {
        //     for (int k = i+1; k < len; k++) {
        //         if(s[i] == s[k+1])
        //             ans+= k-i;
        //     }
        // }
        return ans;
        //  // 出错的地方有：异或初值不能想当然的给0或1 必须用参与运算的值。
        // //以下是第一次解题代码。。垃圾 ，还没通过示例
        // int ans = 0;
        // int a=1;
        // int b = 1;
        // int  len = arr.length;
        // if( len < 3 )
        //     return ans;
        // // 用一个map存储所有的可能的结果。并记录次数。
        // Map<Integer,Integer> map = new HashMap<>();
        // //优先考虑j的值 因为k和i都受他影响
        // for (int j = 1; j < len; j++) {
        //     //i必然比j小 计算a    
        //     for(int i = 0 ; i < j ; i++){
        //         a = arr[i];
        //         for (int ii = i; ii < j ; ii++) {
        //             a ^= arr[ii];
        //         }
        //         if(map.containsKey(a)){
        //             map.put(a, map.get(a)+1);
        //         }else{
        //             map.put(a, 1);
        //         }
        //     }
        //     //k必然>=j大 计算b 
        //     for(int k = j ; k < len ; k++){
        //         b = arr[j];
        //         for(int jj = j ; jj <=k ; jj++){
        //             b ^= arr[jj];
        //         }
        //         if(map.containsKey(b)){
        //             ans += map.get(b);
        //         }
        //     }
        //     map.clear();
        // }
        // return ans;
    }
}
// @lc code=end

