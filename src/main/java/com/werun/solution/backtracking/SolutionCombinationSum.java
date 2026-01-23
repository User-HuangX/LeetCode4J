package com.werun.solution.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>给你一个 <b>无重复元素</b> 的整数数组 {@code candidates} 和一个目标整数 {@code target} ，找出 {@code candidates} 中可以使数字和为目标数 {@code target} 的 所有 <b>不同组合</b> ，并以列表形式返回。你可以按 <b>任意顺序</b> 返回这些组合。</p>
 * <p>{@code candidates} 中的 同一个 数字可以 <b>无限制重复被选取</b> 。如果至少一个数字的被选数量不同，则两种组合是不同的。 </p>
 * <p>对于给定的输入，保证和为 {@code target} 的不同组合数少于 {@code 150} 个。</p>
 */
public class SolutionCombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        this.backtracking(candidates, new ArrayList<>(), ans, target,0,0);
        return ans;
    }

    private void backtracking(int[] candidates, ArrayList<Integer> path, List<List<Integer>> ans, int target, int sum, int start) {
        if(sum == target) {
            ans.add(new ArrayList<>(path));
            return;
        }else if(sum > target) return;
        for (int i = start; i < candidates.length; i++) {
            int candidate = candidates[i];
            path.add(candidate);
            backtracking(candidates, path, ans, target, sum + candidate, i);
            path.removeLast();
        }
    }
}