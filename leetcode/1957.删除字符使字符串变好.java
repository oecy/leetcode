/*
 * @lc app=leetcode.cn id=1957 lang=java
 *
 * [1957] 删除字符使字符串变好
 */

// @lc code=start

class Solution {
    public String makeFancyString(String s) {
        StringBuilder sBuilder = new StringBuilder();
        char cur = s.charAt(0);
        int count=1;
        sBuilder.append(cur);
        for(int i = 1 ; i < s.length() ; i++ ){
            char tmp = s.charAt(i);
            if(cur == tmp){
                if(count == 2){
                    continue;
                }else{
                    count++;
                    sBuilder.append(cur);
                }
            }else{
                cur = tmp;
                count = 1;
                sBuilder.append(cur);
            }
        }
        return sBuilder.toString();
    }
}
// @lc code=end

