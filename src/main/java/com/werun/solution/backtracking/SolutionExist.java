package com.werun.solution.backtracking;

public class SolutionExist {
    boolean ans;

    public static final int[][] DIRECTION = {new int[]{0, 1}, new int[]{0, -1}, new int[]{1, 0}, new int[]{-1, 0}};

    public boolean exist(char[][] board, String word) {
        this.ans = false;
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                this.backtracking(word, board, ans, visited, DIRECTION, i, j, 0);
            }
        }
        return this.ans;
    }

    private void backtracking(String path, char[][] board, boolean ans, boolean[][] visited, int[][] direction, int x, int y, int pos) {
        if(this.ans) return;
        if (path.charAt(pos) != board[x][y]) return;//不匹配返回
        if (visited[x][y]) return;//访问过返回
        if(x > board.length - 1 || y > board[0].length - 1) return;//越界返回
        if(path.length() - 1== pos){
            this.ans = true;
            return;
        }
        visited[x][y] = true;
        for (int[] direct : direction) {
            int nextX = x + direct[0];
            int nextY = y + direct[1];
            if(nextX > board.length - 1 || nextY > board[0].length - 1 || nextX < 0 || nextY < 0) continue;
            backtracking(path, board, ans, visited, direction, nextX, nextY, pos + 1);
        }
        //匹配下一个位置是否字符对应
        visited[x][y] = false;
    }
}
