class Solution {
    public int longestPalindromeSubseq(String str) {
        int n = str.length();

        String revStr = new StringBuilder(str).reverse().toString();

        int dp[][] = new int[n+1][n+1];

        for(int j=0; j<=n; j++) dp[0][n] =0;
        for(int i=0; i<=n; i++) dp[i][0] =0;

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(str.charAt(i-1) == revStr.charAt(j-1)){
                    dp[i][j] = 1+ dp[i-1][j-1];
                    continue;
                }

                int left  = dp[i][j-1];
                int right = dp[i-1][j];

                dp[i][j] = Math.max(left, right);
            }
        }
        return dp[n][n];
    }

    // int LCS(int i, int j, String str1, String str2, int[][] dp){
    //     if(i==-1 || j==-1) return 0;

    //     if(dp[i][j] !=-1) return dp[i][j];

    //     if(str1.charAt(i) == str2.charAt(j))
    //         return 1+ LCS(i-1, j-1, str1, str2, dp);

    //     int left  = LCS(i, j-1, str1, str2, dp);
    //     int right = LCS(i-1, j, str1, str2, dp);

    //     return dp[i][j] = Math.max(left, right);
    // }
}
