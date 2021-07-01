import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=401 lang=java
 *
 * [401] 二进制手表
 */

// @lc code=start
class Solution {
    static Map<Integer, List<String>> map = new HashMap<>();
    static {
        for (int h = 0; h <= 11; h++) {
            for (int m = 0; m <= 59; m++) {
                int tot = getCnt(h) + getCnt(m);
                List<String> list = map.getOrDefault(tot, new ArrayList<String>());
                list.add(h + ":" + (m <= 9 ? "0" + m : m));
                map.put(tot, list);
            }
        }
    }
    static int getCnt(int x) {
        int ans = 0;
        for (int i = x; i > 0; i -= lowbit(i)) ans++;
        return ans;
    }
    static int lowbit(int x) {
        return x & -x;
    }
    public List<String> readBinaryWatch(int t) {
        return map.getOrDefault(t, new ArrayList<>());
    }
}
// @lc code=end

