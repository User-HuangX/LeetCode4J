package com.werun.solution.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个字符串 {@code s}，请你将 {@code s} 分割成一些 <b>子串</b>，使每个子串都是 <b>回文串</b> 。返回 {@code s} 所有可能的分割方案。
 */
public class SolutionpPartition {
    public List<List<String>> partition(String s) {
        ArrayList<List<String>> ans = new ArrayList<>();
        backtracking(ans, new ArrayList<>(), s, 0);
        return ans;
    }

    //分割回文串的核心思想不需要根据上个回文串搜索下个回文串(和manacher算法区分)，只需要将起始节点不断右移剩下部分进行递归操作
    private void backtracking(ArrayList<List<String>> ans, ArrayList<String> path, String s, int start) {
        if (start == s.length()) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if(!isPalindrome(s, start, i)) continue;
            path.add(s.substring(start, i + 1));
            backtracking(ans, path, s, i + 1);
            path.removeLast();
        }
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) if (s.charAt(left++) != s.charAt(right--)) return false;
        return true;
    }
}
