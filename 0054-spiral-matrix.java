class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return result;
        doSpiralOrder(matrix, 0, 0, matrix.length - 1, matrix[0].length - 1, result);
        return result;
    }
    
    private static void doSpiralOrder(int[][] matrix, int top, int left, int bottom, int right, List<Integer> result) {
        if (top > bottom || left > right) return;

        for (int i = left; i <= right; i++) result.add(matrix[top][i]);
        for (int i = top + 1; i <= bottom; i++) result.add(matrix[i][right]);
        if (bottom > top)
            for (int i = right - 1; i >= left; i--) result.add(matrix[bottom][i]);
        if (left < right)
            for (int i = bottom - 1; i >= top + 1; i--) result.add(matrix[i][left]);

        doSpiralOrder(matrix, top + 1, left + 1, bottom - 1, right - 1, result);
    }
}
