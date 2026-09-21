class Solution {
    public int uniquePathsWithObstacles(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];
        for(int i=0; i<m; i++) Arrays.fill(dp[i], -1);

        return totalWays(0, 0, m, n, dp, matrix);
    }

    int totalWays(int i, int j, int rows, int columns, int[][] dp, int[][] matrix){
        if(matrix[i][j]==1) return 0;

        if(i==rows-1 && j==columns-1) return 1;

        if(dp[i][j] !=-1) return dp[i][j];

        int right =0;
        if(j+1 < columns)
            right = totalWays(i, j+1, rows, columns, dp, matrix);

        int bottom =0;
        if(i+1 < rows)
            bottom = totalWays(i+1, j, rows, columns, dp, matrix);

        return dp[i][j] = right+bottom;
    }
}