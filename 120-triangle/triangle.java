class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();

        int[][] dp = new int[n][];
        for(int i=0; i<n; i++){
            dp[i] = new int[i+1];
        }

        //set base cases for the last row
        for(int j=0; j<n; j++) dp[n-1][j] = triangle.get(n-1).get(j);

        for(int i=n-2; i>=0; i--){
            for(int j=0; j<dp[i].length; j++){
                int left = dp[i+1][j];
                int right = dp[i+1][j+1];

                dp[i][j] = triangle.get(i).get(j) + Math.min(left, right);
            }
        }
        return dp[0][0];
    }
}

// 0
// 01
// 012
// 0123
