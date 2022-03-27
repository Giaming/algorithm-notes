package org.algo.图.岛屿问题;

public class P130Solve {
    /**
     * 1.如果涉及到被包围的‘O’的区域，此时要区分被包围的‘O’和未被包围的‘O’
     * 1）遍历网格的边界，遇到‘O’就把它和它周围的‘O’污染；网格中剩下的‘O’是被包围的；
     * 2）遍历整个网格，处理遍历到的‘O’
     */
    public void solve(char[][] board) {
        if (board == null) return;
        int m = board.length, n = board[0].length;

        // 首先对边界进行污染
        for (int i = 0; i < m; i++) {
            int j = 0;
            if (board[i][j] == 'O') pollute(board, i, j);
            j = n - 1;
            if (board[i][j] == 'O') pollute(board, i, j);
        }
        for (int j = 0; j < n; j++) {
            int i = 0;
            if (board[i][j] == 'O') pollute(board, i, j);
            i = m - 1;
            if (board[i][j] == 'O') pollute(board, i, j);
        }
        //网格中剩下的‘O’是被包围的, 遍历整个网格，处理遍历到的'O'
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'S') {
                    board[i][j] = 'O';
                }else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
    private void pollute(char[][] board, int i, int j) {
        if (i >= 0 && i < board.length && j >= 0 && j < board[0].length) {
            //遇到‘O’就把它和它周围的‘O’污染
            if (board[i][j] == 'O') {
                board[i][j] = 'S';  // 污染
                pollute(board, i+1, j);
                pollute(board, i-1, j);
                pollute(board, i, j+1);
                pollute(board, i, j-1);
            }
        }
    }
}
