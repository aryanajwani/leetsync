class Solution {
    public int longestPalindromeSubseq(String str) {
        int n = str.length();
        String revStr = new StringBuilder(str).reverse().toString();

        int dp[][] = new int[n][n];
        for(int i=0; i<n; i++) Arrays.fill(dp[i], -1);

        return LCS(n-1, n-1, str, revStr, dp);
    }

    int LCS(int i, int j, String str1, String str2, int[][] dp){
        if(i==-1 || j==-1) return 0;

        if(dp[i][j] !=-1) return dp[i][j];

        if(str1.charAt(i) == str2.charAt(j))
            return 1+ LCS(i-1, j-1, str1, str2, dp);

        int left  = LCS(i, j-1, str1, str2, dp);
        int right = LCS(i-1, j, str1, str2, dp);

        return dp[i][j] = Math.max(left, right);
    }
}
