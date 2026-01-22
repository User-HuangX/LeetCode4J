package com.werun.solution.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>给你一个整数数组 {@code nums} ，数组中的元素 <b>互不相同</b> 。返回该数组所有可能的子集（幂集）。</p>
 * <p>解集 <b>不能</b> 包含重复的子集。你可以按 <b>任意顺序</b> 返回解集。</p>
 */
public class SolutionSubsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtracking(nums, new ArrayList<>(), ans, 0);
        return ans;
    }

    private void backtracking(int[] nums, ArrayList<Integer> path, List<List<Integer>> ans, int start) {
        ans.add(new ArrayList<>(path));
        for (int i = start; i < nums.length; i++) {
            path.addLast(nums[i]);
            backtracking(nums, path, ans, i + 1);
            path.removeLast();
        }
    }
}
