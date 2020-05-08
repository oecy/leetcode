

/*
 * @lc app=leetcode.cn id=983 lang=java
 *
 * [983] 最低票价
 *
 * https://leetcode-cn.com/problems/minimum-cost-for-tickets/description/
 *
 * algorithms
 * Medium (56.37%)
 * Likes:    155
 * Dislikes: 0
 * Total Accepted:    12K
 * Total Submissions: 19.6K
 * Testcase Example:  '[1,4,6,7,8,20]\n[2,7,15]'
 *
 * 在一个火车旅行很受欢迎的国度，你提前一年计划了一些火车旅行。在接下来的一年里，你要旅行的日子将以一个名为 days 的数组给出。每一项是一个从 1 到
 * 365 的整数。
 * 
 * 火车票有三种不同的销售方式：
 * 
 * 
 * 一张为期一天的通行证售价为 costs[0] 美元；
 * 一张为期七天的通行证售价为 costs[1] 美元；
 * 一张为期三十天的通行证售价为 costs[2] 美元。
 * 
 * 
 * 通行证允许数天无限制的旅行。 例如，如果我们在第 2 天获得一张为期 7 天的通行证，那么我们可以连着旅行 7 天：第 2 天、第 3 天、第 4
 * 天、第 5 天、第 6 天、第 7 天和第 8 天。
 * 
 * 返回你想要完成在给定的列表 days 中列出的每一天的旅行所需要的最低消费。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：days = [1,4,6,7,8,20], costs = [2,7,15]
 * 输出：11
 * 解释： 
 * 例如，这里有一种购买通行证的方法，可以让你完成你的旅行计划：
 * 在第 1 天，你花了 costs[0] = $2 买了一张为期 1 天的通行证，它将在第 1 天生效。
 * 在第 3 天，你花了 costs[1] = $7 买了一张为期 7 天的通行证，它将在第 3, 4, ..., 9 天生效。
 * 在第 20 天，你花了 costs[0] = $2 买了一张为期 1 天的通行证，它将在第 20 天生效。
 * 你总共花了 $11，并完成了你计划的每一天旅行。
 * 
 * 
 * 示例 2：
 * 
 * 输入：days = [1,2,3,4,5,6,7,8,9,10,30,31], costs = [2,7,15]
 * 输出：17
 * 解释：
 * 例如，这里有一种购买通行证的方法，可以让你完成你的旅行计划： 
 * 在第 1 天，你花了 costs[2] = $15 买了一张为期 30 天的通行证，它将在第 1, 2, ..., 30 天生效。
 * 在第 31 天，你花了 costs[0] = $2 买了一张为期 1 天的通行证，它将在第 31 天生效。 
 * 你总共花了 $17，并完成了你计划的每一天旅行。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= days.length <= 365
 * 1 <= days[i] <= 365
 * days 按顺序严格递增
 * costs.length == 3
 * 1 <= costs[i] <= 1000
 * 
 * 
 */

// @lc code=start
class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days[days.length-1];//最大的天数

        int length = days.length;
        int[] dp = new int[n+1];

        int a,b,c;
        for(int i = 0 ; i < length ; ++i){
            dp[days[i]] = -1;//将去旅行的天数进行标记
        }

        for(int i = 1 ; i <= n ; ++i){
            if(dp[i] == 0)          //如果当天不旅行 最小值为前一天的最小值
                dp[i] = dp[i-1];
            else{
                a = dp[i-1] + costs[0];// a为前一天的最小值 加上再买一天的值
                if(i - 7 >= 0)
                    b = dp[i-7] + costs[1];//如果当前天数已经在7天以上那么b为七天前加买一周的值
                else    
                    b = costs[1];//不满7天那就是按七天的计算
                if(i - 30 >= 0)
                    c = dp[i-30] + costs[2];//已经过了一个月
                else    
                    c = costs[2]; 

                dp[i] = Math.min(a, Math.min(c, b));//取三者最小值  
            }
        }

        return dp[n];

    }
}
// @lc code=end

