package com.werun.solution.binarytree;

import com.werun.datastructure.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个二叉树的根节点 {@code root} ，和一个整数 {@code targetSum} ，求该二叉树里节点值之和等于 {@code targetSum} 的 路径 的数目。
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 */
public class SolutionPathSum {
    private int res = 0;
    private final Map<Long, Integer> prefixSum = new HashMap<>();

    public int pathSum(TreeNode root, int targetSum) {
        prefixSum.put(0L, 1); // 非常关键
        dfs(root, 0L, targetSum);
        return res;
    }

    private void dfs(TreeNode node, long currSum, int targetSum) {
        if (node == null) return;

        currSum += node.val;

        // 看之前有多少个前缀和满足
        res += prefixSum.getOrDefault(currSum - targetSum, 0);

        prefixSum.put(currSum, prefixSum.getOrDefault(currSum, 0) + 1);

        dfs(node.left, currSum, targetSum);
        dfs(node.right, currSum, targetSum);

        // 回溯
        prefixSum.put(currSum, prefixSum.get(currSum) - 1);
    }
}

