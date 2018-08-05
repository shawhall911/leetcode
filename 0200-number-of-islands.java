class Solution {
    
    
    int m; //m rows; if we deinfed here, don't redefine in methods!
    int n; //n cols
    
    public int numIslands(char[][] grid) {
        
        m = grid.length;
        if( m < 1) return 0;
        
        n = grid[0].length;
        
        if (n < 1 ) return 0;
        
        int cnt = 0;
        for (int i = 0; i < m; i ++)
            for (int j = 0 ; j < n; j ++){
                
                if(grid[i][j] == '1'){
                    cnt++;
                    dfs(grid, i, j); //dfs will mark all 1s in this island as 'x'
                    
                }
            }                
        return cnt;
    }
    
    void dfs(char[][] grid, int i2, int j2){
        
        if(i2 < 0 || j2 < 0 || i2 > m-1 || j2 > n - 1) return;
        
        if(grid[i2][j2] != '1') return;
        
        //System.out.println("here i: " + i2 + " j: " + j2 + "m: " + m + "n: " + n);
        grid[i2][j2] = 'x';

        //up, right, down, left
            dfs(grid, i2-1, j2); 
        
            dfs(grid, i2, j2+1);
        
            dfs(grid, i2+1, j2); 
        
            dfs(grid, i2, j2-1);

        return;                    
        
    }
}
