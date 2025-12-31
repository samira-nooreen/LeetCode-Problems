/* 79. Word Search
Medium
Topics
premium lock icon
Companies
Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

 

Example 1:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true */
class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, 0, i, j, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int idx, int i, int j, boolean[][] visited) {
        if (idx == word.length()) return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return false;
        if (visited[i][j] || board[i][j] != word.charAt(idx)) return false;

        visited[i][j] = true;
        boolean found = dfs(board, word, idx + 1, i + 1, j, visited) ||
                        dfs(board, word, idx + 1, i - 1, j, visited) ||
                        dfs(board, word, idx + 1, i, j + 1, visited) ||
                        dfs(board, word, idx + 1, i, j - 1, visited);
        visited[i][j] = false;

        return found;
    }
}
