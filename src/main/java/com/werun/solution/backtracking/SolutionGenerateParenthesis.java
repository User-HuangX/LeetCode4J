package com.werun.solution.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字 {@code n} 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 <b>有效的</b> 括号组合。
 */
public class SolutionGenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        this.backtracking(n * 2, new StringBuilder(), ans, new char[]{'(', ')'}, 0);
        return ans;
    }

    private void backtracking(int maxLen, StringBuilder path, List<String> ans, char[] parenthesis, int left) {
        if (path.length() == maxLen && left == 0) {
            ans.add(new String(path));
        } else if (path.length() > maxLen) return;
        for (int i = 0; i < parenthesis.length; i++) {
            if (left <= 0 && i == 1) return;
            if (left > maxLen / 2) return;
            left += i == 0 ? 1 : -1;
            path.append(parenthesis[i]);
            backtracking(maxLen, path, ans, parenthesis, left);
            path.deleteCharAt(path.length() - 1);
            left += i == 0 ? -1 : 1;
        }
    }
}
