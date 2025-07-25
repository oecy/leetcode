/*
 * @lc app=leetcode.cn id=1717 lang=java
 *
 * [1717] 删除子字符串的最大得分
 */

// @lc code=start
class Solution {
    public int maximumGain(String s, int x, int y) {
        return x>y? getMax(s,'a','b',x,y):getMax(s,'b','a',y,x);
    }

    private int getMax(String s, char a,char b,int x,int y){
        int c1 = 0,c2 = 0,ans = 0;
        s=s+"c";
        for (char c : s.toCharArray()) {
            if(c == a){
                c1++;
            }else if(c == b){
                if(c1 == 0){
                    c2++;
                }else {
                    ans+=x;
                    c1--;
                }
            }else {
                ans+=(y*Math.min(c1,c2));
                c1 = 0;c2 = 0;
            }
        }
        return ans;
    }
}
// @lc code=end

