package com.werun.solution.graph;

import java.util.*;

/**
 * <p>你这个学期必须选修 {@code numCourses} 门课程，记为 {@code 0} 到 {@code numCourses - 1} 。</p>
 * <p>在选修某些课程之前需要一些先修课程。 先修课程按数组  {@code prerequisites} 给出，其中 {@code prerequisites[i] = [a_i, b_i]} ，表示如果要学习课程 {@code a_i} 则 必须 先学习课程  {@code b_i} 。</p>
 * <p>例如，先修课程对 {@code [0, 1]} 表示：想要学习课程 {@code 0} ，你需要先完成课程 {@code 1} 。</p>
 * <p>请你判断是否可能完成所有课程的学习？如果可以，返回 {@code true} ；否则，返回{@code false}  。</p>
 */
public class SolutionCanFinish {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        //造好邻接表和入度表
        for(int[] prerequisite:prerequisites){
            graph.computeIfAbsent(prerequisite[1], _ -> new ArrayList<>()).add(prerequisite[0]);
            indegree[prerequisite[0]]++;
        }
        //使用广度优先收搜索
        Queue<Integer> queue = new ArrayDeque<>();
        //找到入度为0的节点放在这个队列当中
        int learned = 0;
        for (int i = 0; i < indegree.length; i++) if (indegree[i] == 0) queue.add(i);
        while (!queue.isEmpty()){
            Integer num = queue.poll();
            learned++;
            graph.getOrDefault(num,new ArrayList<>()).forEach(i -> {
                indegree[i]--;
                if(indegree[i] == 0) queue.add(i);
            });
        }
        return learned == numCourses;
    }

}
