class Solution {
    public void solveSudoku(char[][] board) {
        doSudoku(board, 0, 0);
    }
    
    private boolean doSudoku(char[][] board, int r, int c) {
        if (r >= 9) return true;
        
        int nextC = (c + 1) % 9;
        int nextR = nextC == 0 ? r + 1 : r;
        if (board[r][c] != '.') return doSudoku(board, nextR, nextC);
        
        for (char k = '1'; k <= '9'; k++){
            if (isValid(board, r, c, k)) {
                board[r][c] = k;
                if (doSudoku(board, nextR, nextC)) return true;
                
            }
        }
        board[r][c] = '.';
        return false;
    }
    
    private boolean isValid(char[][] board, int r, int c, char k) {
        for (int i = 0; i < 9; i++) {
            if (board[r][i] == k) return false;
            if (board[i][c] == k) return false;
        }
        
        int startR = r / 3 * 3;
        int startC = c / 3 * 3;
        for (int i = startR; i < startR + 3; i++)
            for (int j = startC; j < startC + 3; j++)
                if (board[i][j] == k) return false;
        
        return true;
    }
}
