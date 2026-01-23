package com.werun.solution.backtracking;

import java.util.*;

public class SolutionLetterCombinations {
    private static final String[] MAPPING = new String[] {
            "", //0
            "", //1
            "abc", //2
            "edf",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        ArrayList<String> ans = new ArrayList<>();
        backtracking(digits, new StringBuffer(), ans, 0);
        return ans;
    }

    private void backtracking(String digits, StringBuffer path, ArrayList<String> ans, int start) {
        if (path.length() == digits.length()) {
            ans.add(path.toString());
            return;
        }
        char[] charArray = digits.toCharArray();
        for (int i = start, charArrayLength = charArray.length; i < charArrayLength; i++) {
            int num = charArray[i] - '0';
            for (int j = 0; j < MAPPING[num].length(); j++) {
                path.append(MAPPING[num].charAt(j));
                backtracking(digits, path, ans, i + 1);
                path.deleteCharAt(path.length() - 1);
            }
        }
    }
}
