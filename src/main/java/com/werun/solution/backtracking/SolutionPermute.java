package com.werun.solution.backtracking;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
/**
 * 给定一个不含重复数字的数组 {@code nums} ，返回其 <i>所有可能的全排列</i> 。
 * 你可以 <b>按任意顺序</b> 返回答案。
 */

public class SolutionPermute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ArrayDeque<Integer> path = new ArrayDeque<>();
        backtracking(nums,path,ans);
        return ans;
    }

    private void backtracking(int[] nums, ArrayDeque<Integer> path, List<List<Integer>> ans) {
        if (path.size() == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int num : nums) {
            if (path.contains(num)) continue;
            path.addLast(num);
            backtracking(nums, path, ans);
            path.removeLast();
        }
    }
}
