import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1418 lang=java
 *
 * [1418] 点菜展示表
 */

// @lc code=start
class Solution {
    /**
     *  分别统计每一个订单中的 桌号和菜品的名称
     */
    public List<List<String>> displayTable(List<List<String>> orders) {
        //菜品的名称Set Set会自动过滤相同的key值
        Set<String> nameSet = new HashSet<>();
        //每一卓的菜品统计 <桌号，<菜品名称，数量>>
        Map<Integer, Map<String, Integer>> foodsCnt = new HashMap<Integer, Map<String, Integer>>();
        for (List<String> order : orders) {
            nameSet.add(order.get(2));
            int id = Integer.parseInt(order.get(1));
            Map<String, Integer> map = foodsCnt.getOrDefault(id, new HashMap<String, Integer>());
            map.put(order.get(2), map.getOrDefault(order.get(2), 0) + 1);
            foodsCnt.put(id, map);
        }
        //因为要按照菜品的字母顺序升序 故进行排序，排序使用list
        List<String> nameList = new ArrayList<>();
        for(String name : nameSet){
            nameList.add(name);
        }
        //使用Collections工具类对nameList进行排序
        Collections.sort(nameList);

        //构建结果List
        List<List<String>> ans = new ArrayList<>();
        //第一行的数据 显示菜品
        List<String> first = new ArrayList<>();
        first.add("Table");
        for(int i = 0 ; i < nameList.size() ; i++){
            first.add(nameList.get(i));
        }
        //将第一行放入结果数组中
        ans.add(first);

        List<Integer> tables = new ArrayList<>();
        for(Integer i : foodsCnt.keySet()){
            tables.add(i);
        }
        //对桌号进行排序
        Collections.sort(tables);

        //遍历桌号并创建具体的餐品数量
        for(int i = 0 ; i < tables.size() ; i++){
            int id = tables.get(i);
            //获得对应桌号的菜品
            Map<String,Integer> cnt = foodsCnt.get(id);
            List<String> array = new ArrayList<>();
            array.add(String.valueOf(id));
            for(String name : nameList){
                array.add(String.valueOf(cnt.getOrDefault(name, 0)));
            }
            ans.add(array);
        }
        return ans;
    }
}
// @lc code=end

