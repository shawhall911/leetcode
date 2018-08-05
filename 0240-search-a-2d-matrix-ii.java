class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null) return false;
        int m = matrix.length;
        if (m == 0) return false;
        int n = matrix[0].length;
        if (n == 0) return false;
        if (target < matrix[0][0] || target > matrix[m - 1][n - 1]) return false;

        int i = 0;
        int j = n - 1;
        while (i >= 0 && i < m && j >= 0 && j < n)
        {
            if (target < matrix[i][j]) j--;
            else if (target > matrix[i][j]) i++;
            else return true;
        }

        return false;
    
    }
}
