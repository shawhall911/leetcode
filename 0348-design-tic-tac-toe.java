class TicTacToe {
    private int n;
    private int[][] grid;
    private int winner = 0;
    
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        this.n = n;
        this.grid = new int[n][];
        for (int i = 0; i < n; i++) this.grid[i] = new int[n];
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        if (this.winner > 0) return this.winner;
        
        this.grid[row][col] = player;
        
        boolean won = true;
        for (int i = 0; i < n; i++) {
            if (this.grid[row][i] != player) {
                won = false;
                break;
            }
        }
        if (won) {
            this.winner = player;
            return this.winner; 
        }
        
        won = true;
        for (int i = 0; i < n; i++) {
            if (this.grid[i][col] != player) {
                won = false;
                break;
            }
        }
        if (won) {
            this.winner = player;
            return this.winner; 
        }
        
        if (row == col) {
            won = true;
            for (int i = 0; i < n; i++) {
                if (this.grid[i][i] != player) {
                    won = false;
                    break;
                }
            }
            if (won) {
                this.winner = player;
                return this.winner; 
            }
        }
        
        if (row == n - 1 - col) {
            won = true;
            for (int i = 0; i < n; i++) {
                if (this.grid[i][n - 1 - i] != player) {
                    won = false;
                    break;
                }
            }
            if (won) {
                this.winner = player;
                return this.winner; 
            }
        }
        
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
