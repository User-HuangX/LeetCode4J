package com.werun.solution.binarytree;

import com.werun.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树的 <b>根节点</b> {@code root}，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 */
public class SolutionRightSideView {
    ArrayList<Integer> list = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        helper(root, 0);
        return list;
    }

    private void helper(TreeNode root, int h) {
        if (root == null) return;
        if (list.size() <= h) list.add(root.val);
        helper(root.right, h + 1);
        helper(root.left, h + 1);
    }
}
