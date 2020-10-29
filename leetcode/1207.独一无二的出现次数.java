
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;



/*
 * @lc app=leetcode.cn id=1207 lang=java
 *
 * [1207] 独一无二的出现次数
 */

// @lc code=start
class Solution {
    public boolean uniquemaprences(int[] arr) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int x : arr) {
            map.put(x, map.getOrDefault(x, 0)+1);
        }
        Set<Integer> times = new HashSet<Integer>();
        for (Map.Entry<Integer, Integer> x : map.entrySet()) {
            times.add(x.getValue());
        }
        return times.size() == map.size();
    }
}
// @lc code=end

