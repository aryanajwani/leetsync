class Solution {
    public int findMaxForm(String[] strs, int zeroes, int ones) {
        int n = strs.length;
        int dp[][][] = new int[n][zeroes+1][ones+1];

        //set base cases
        int[][] count = new int[n][2];
        generateCount(count, strs);

        for(int z=0; z<=zeroes; z++){
            for(int o=0; o<=ones; o++){
                if(count[0][0]<=z && count[0][1]<=o) dp[0][z][o] = 1;
                else dp[0][z][o] = 0;
            }
        }


        for(int i=1; i<n; i++){
            for(int z=0; z<=zeroes; z++){
                for(int o=0; o<=ones; o++){
                    int nottake = dp[i-1][z][o];

                    int take = Integer.MIN_VALUE;

                    if(count[i][0]<=z && count[i][1]<=o)
                        take = 1 + dp[i-1][z-count[i][0]][o-count[i][1]];

                    dp[i][z][o] = Math.max(take, nottake);
                }
            }
        }

        return dp[n-1][zeroes][ones];
    }

    void generateCount(int[][] count, String[] strs){
        int n = strs.length;

        for(int i=0; i<strs.length; i++){
            String str = strs[i];

            for(int j=0; j<str.length(); j++){

                if(str.charAt(j)=='0') count[i][0]++;
                else count[i][1]++; 
            }
        }
    }    
}