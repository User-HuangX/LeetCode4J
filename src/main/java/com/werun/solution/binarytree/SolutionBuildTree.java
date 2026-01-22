package com.werun.solution.binarytree;

import com.werun.datastructure.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个整数数组 {@code preorder} 和 {@code inorder} ，其中 {@code preorder} 是二叉树的<b>先序遍历</b>，{@code inorder} 是同一棵树的<b>中序遍历</b>，请构造二叉树并返回其根节点。
 */
public class SolutionBuildTree {

    private int preIndex = 0;
    private final Map<Integer, Integer> indexMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) indexMap.put(inorder[i], i);
        return helper(preorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int inLeft, int inRight) {
        if (inLeft > inRight) return null;
        int rootVal = preorder[preIndex++];
        TreeNode root = new TreeNode(rootVal);
        int k = indexMap.get(rootVal);
        root.left = helper(preorder, inLeft, k - 1);
        root.right = helper(preorder, k + 1, inRight);
        return root;
    }
}
