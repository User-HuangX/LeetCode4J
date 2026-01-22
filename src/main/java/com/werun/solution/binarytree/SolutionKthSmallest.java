package com.werun.solution.binarytree;

import com.werun.datastructure.TreeNode;

/**
 * 给定一个<b>二叉搜索树</b>的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 小的元素（k 从 1 开始计数）
 */
public class SolutionKthSmallest {
    int count;
    int ans;

    public int kthSmallest(TreeNode root, int k) {
        kthSmallestHelper(root, k);
        return ans;
    }

    private void kthSmallestHelper(TreeNode root, int k) {
        if (root == null) return;
        kthSmallestHelper(root.left, k);
        if (++count == k) ans = root.val;
        kthSmallestHelper(root.right, k);
    }
}
