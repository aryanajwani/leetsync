class Solution {
    public int findMaxForm(String[] strs, int zeroes, int ones) {
        int n = strs.length;
        int dp[][][] = new int[n][zeroes+1][ones+1];

        //set base cases
        int[] count = count(strs[0]);
        for(int z=0; z<=zeroes; z++){
            for(int o=0; o<=ones; o++){
                if(count[0]<=z && count[1]<=o) dp[0][z][o] = 1;
                else dp[0][z][o] = 0;
            }
        }

        for(int i=1; i<n; i++){
            for(int z=0; z<=zeroes; z++){
                for(int o=0; o<=ones; o++){
                    int nottake = dp[i-1][z][o];

                    count = count(strs[i]);
                    int take = Integer.MIN_VALUE;

                    if(count[0]<=z && count[1]<=o)
                        take = 1 + dp[i-1][z-count[0]][o-count[1]];

                    dp[i][z][o] = Math.max(take, nottake);
                }
            }
        }

        return dp[n-1][zeroes][ones];
    }

    int maxFrom(int i, int z, int o, String[] strs, int[][][] dp){
        if(i==0){
            int[] count = count(strs[i]);

            if(count[0]<=z && count[1]<=o) return 1;
            else return 0;
        }

        if(dp[i][z][o] !=-1) return dp[i][z][o];

        int nottake = maxFrom(i-1, z, o, strs, dp);

        int[] count = count(strs[i]);
        int take = Integer.MIN_VALUE;

        if(count[0]<=z && count[1]<=o)
            take = 1 + maxFrom(i-1, z-count[0], o-count[1], strs, dp);

        return dp[i][z][o] = Math.max(take, nottake);
    }

    int[] count(String str){
        int n = str.length();

        int result[] = new int[2];

        for(int i=0; i<n; i++){
            if(str.charAt(i)=='0') result[0]++;
            else result[1]++; 
        }

        return result;
    }    
}