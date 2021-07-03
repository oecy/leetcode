/*
 * @lc app=leetcode.cn id=451 lang=java
 *
 * [451] 根据字符出现频率排序
 */

// @lc code=start
class Solution {
    /**
     * 这题就是统计出现的次数并按照出现次数从大到小排序
     * 基础思路：利用Map统计出现的所有的字母的次数。
     *          然后对所有的字母进行排序，利用Collections.sort(list, compoartor)排序
     *          之后将Sb 遍历添加字母
     */
    public String frequencySort(String s) {
        //HashMap key为char字母。value为其出现的次数
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int length = s.length();
        //统计次数
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            int frequency = map.getOrDefault(c, 0) + 1;
            map.put(c, frequency);
        }
        //获取list 即 所有出现的字母
        List<Character> list = new ArrayList<Character>(map.keySet());
        //对这些字母出现的顺序按照降序排列 利用Collections.sort 方法 需要传入自定义比较器 此处使用Lambda写法
        Collections.sort(list, (a, b) -> map.get(b) - map.get(a));
        StringBuffer sb = new StringBuffer();
        int size = list.size();
        //按照每个字母的出现次数，依次加入sb
        for (int i = 0; i < size; i++) {
            char c = list.get(i);
            int frequency = map.get(c);
            for (int j = 0; j < frequency; j++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
// @lc code=end

