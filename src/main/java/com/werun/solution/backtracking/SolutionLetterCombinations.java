package com.werun.solution.backtracking;

import java.util.*;

public class SolutionLetterCombinations {
    private static final Map<Character, Character[]> MAP = new HashMap<>(8);
    static {
        MAP.put('2', new Character[]{'a', 'b', 'c'});
        MAP.put('3', new Character[]{'d', 'e', 'f'});
        MAP.put('4', new Character[]{'g', 'h', 'i'});
        MAP.put('5', new Character[]{'j', 'k', 'l'});
        MAP.put('6', new Character[]{'m', 'n', 'o'});
        MAP.put('7', new Character[]{'p', 'q', 'r', 's'});
        MAP.put('8', new Character[]{'t', 'u', 'v'});
        MAP.put('9', new Character[]{'w', 'x', 'y', 'z'});
    }
    public List<String> letterCombinations(String digits) {
        ArrayList<String> ans = new ArrayList<>();
        backtracking(digits, new StringBuffer(),ans,0);
        return ans;
    }

    private void backtracking(String digits, StringBuffer path, ArrayList<String> ans, int start) {
        if (path.length() == digits.length()) {
            ans.add(path.toString());
            return;
        }
        char[] charArray = digits.toCharArray();
        for (int i = start, charArrayLength = charArray.length; i < charArrayLength; i++) {
            char c = charArray[i];
            for (int j = 0; j < MAP.get(c).length; j++) {
                path.append(MAP.get(c)[j]);
                backtracking(digits, path, ans, i + 1);
                path.deleteCharAt(path.length()-1);
            }
        }
    }
}
