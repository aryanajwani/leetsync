class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix[0].length;
        int n = matrix.length;

        int dp[][] = new int[n][m];
        for(int i=0; i<n; i++) Arrays.fill(dp[i], Integer.MAX_VALUE);

        int min = Integer.MAX_VALUE;
        for(int i=0; i<m; i++){
            min = Math.min(min, minFrom(0, i, matrix, dp));
        }

        return min;
    }

    int minFrom(int i, int j, int[][] matrix, int[][] dp){
        if(i==matrix.length-1) return matrix[i][j];

        if(dp[i][j] != Integer.MAX_VALUE) return dp[i][j];

        int left = Integer.MAX_VALUE;
        if(isValid(j-1, matrix)) left = minFrom(i+1, j-1, matrix, dp);

        int middle = Integer.MAX_VALUE;
        if(isValid(j, matrix)) middle = minFrom(i+1, j, matrix, dp);
        
        int right =  Integer.MAX_VALUE;
        if(isValid(j+1, matrix)) right = minFrom(i+1, j+1, matrix, dp);

        return dp[i][j] = matrix[i][j] + Math.min(left, Math.min(middle, right));
    }

    boolean isValid(int j, int[][] matrix){
        int m= matrix[0].length;

        return j>=0 && j<m;
    }
}

// [2,1,3],
// [6,5,4],
// [7,8,9]