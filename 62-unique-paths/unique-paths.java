class Solution {
    public int uniquePaths(int m, int n) {
        int[] prev = new int[n];
        int[] current = new int[n];

        for(int i=0; i<n; i++) prev[i] = 1;

        for(int i=m-2; i>=0; i--){
            for(int j=n-1; j>=0; j--){

                int right =0;
                if(j+1 < n) right = current[j+1];

                int bottom = prev[j];

                current[j] = right+bottom;
            }

            int[] temp= prev;
            prev = current;
            current = temp;
        }

        return prev[0];
    }
}