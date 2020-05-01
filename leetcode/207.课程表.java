import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=207 lang=java
 *
 * [207] 课程表
 *
 * https://leetcode-cn.com/problems/course-schedule/description/
 *
 * algorithms
 * Medium (49.64%)
 * Likes:    308
 * Dislikes: 0
 * Total Accepted:    34.5K
 * Total Submissions: 68.6K
 * Testcase Example:  '2\n[[1,0]]'
 *
 * 你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。
 * 
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1]
 * 
 * 给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？
 * 
 * 
 * 
 * 示例 1:
 * 
 * 输入: 2, [[1,0]] 
 * 输出: true
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。
 * 
 * 示例 2:
 * 
 * 输入: 2, [[1,0],[0,1]]
 * 输出: false
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 输入的先决条件是由 边缘列表 表示的图形，而不是 邻接矩阵 。详情请参见图的表示法。
 * 你可以假定输入的先决条件中没有重复的边。
 * 1 <= numCourses <= 10^5
 * 
 * 
 */

// @lc code=start
class Solution {
    /**
     * 解题思路：看到这个题目第一感觉就是判断图中有没有环，有环的话返回false
     *          那就是使用拓扑排序
     * 根据题意 pre这个二维数组就是一个邻接表且其边是有向的。其结构如下(列数为2)
     *  1 0
     *  2 3
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites == null)//特殊情况给优先处理掉
            return false;
        
        //入度表
        int[] indegrees = new int[numCourses];
        //邻接表
        List<List<Integer>> adjList = new ArrayList<>();
        //辅助队列
        Queue<Integer> queue = new LinkedList<>();

        //邻接表初始化
        for(int i = 0 ; i < numCourses ; ++i){
            adjList.add(new ArrayList<>());
        }

        //从二维数组中取每一个一位数组  将入度和邻接表
        for(int[] cp : prerequisites) {
           indegrees[cp[0]]++;
           adjList.get(cp[1]).add(cp[0]);
        }
        //查询入度表  将入度为0的加入队列中等待删除 进行拓扑排序
        for(int i = 0  ; i < numCourses ; ++i){
            if(indegrees[i] == 0)
                queue.add(i);
        }

        //当队列不为空时，即还有入度为0得到节点时。继续拓扑排序
        while(!queue.isEmpty()){
            //取出当前入度为0的节点
            int pre = queue.poll();
            //将课程的总数减一  因为已经剔除了一门入度为0的课
            --numCourses;
            //从pre节点中找出所有以他为前置节点的课程
            for(int cur : adjList.get(pre)){
                //并将这些课程入度减一  如果入度为0  则将之入读待删除 
                if(--indegrees[cur] == 0) 
                    queue.add(cur);
            }
        }
        return numCourses == 0;
        
        

    }
}
// @lc code=end

