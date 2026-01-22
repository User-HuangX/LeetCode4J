package com.werun.solution.binarytree;

import com.werun.datastructure.TreeNode;

/**
 * 二叉树中的 <b>路径</b> 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。同一个节点在一条路径序列中<b>至多出现一次</b> 。该路径 <b>至少包含一个</b> 节点，且不一定经过根节点。
 * <p>路径和 是路径中各节点值的总和。</p>
 * <p>给你一个二叉树的根节点 {@code root} ，返回其 最大路径和 。</p>
 */
public class SolutionMaxPathSum {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        //从下往上想
        if(root == null) return 0;
        helper(root);
        return max;
    }
    private int helper(TreeNode root){
        if(root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        max = Math.max(max, left + right + root.val);
        return Math.max(root.val + Math.max(left, right), 0);
    }
}
