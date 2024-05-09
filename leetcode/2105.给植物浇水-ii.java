/*
 * @lc app=leetcode.cn id=2105 lang=java
 *
 * [2105] 给植物浇水 II
 */

// @lc code=start
class Solution {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int res = 0;
        int aleft = capacityA;
        int bleft = capacityB;
        for(int i = 0 ; i < plants.length ; i++){
            int j = plants.length - 1 - i;
            if( i > j )
                break;
            if( i == j){
                if(aleft < plants[i] && bleft < plants[i]){
                    res +=1;
                }
                break;
            } 

            //如果两个容量都可以浇水
            if(plants[i] <= aleft && plants[j] <= bleft){
                aleft -= plants[i];
                bleft -= plants[j];
            } else if(plants[i] <= aleft && plants[j] > bleft){
                //a可以浇 b不可以浇水
                res+=1;
                bleft = capacityB - plants[j];
                aleft -= plants[i];
            } else if(plants[i] > aleft && plants[j] <= bleft){
                //b可以浇 a不可以浇水
                res+=1;
                aleft = capacityA - plants[i];
                bleft -= plants[j];
            }else{
                res+=2;
                aleft = capacityA - plants[i];
                bleft = capacityB - plants[j];
            }

        }


        return res;
    }
}
// @lc code=end

