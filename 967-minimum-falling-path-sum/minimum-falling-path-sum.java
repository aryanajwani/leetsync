class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix[0].length;
        int n = matrix.length;

        int next[] = new int[m];
        int current[] = new int[m];

        for(int j=0; j<m; j++) next[j] = matrix[n-1][j];

        for(int i=n-2; i>=0; i--){
            for(int j=0; j<m; j++){

                int middle = next[j];

                int left = Integer.MAX_VALUE;
                if(j>0) left = next[j-1];
  
                int right =  Integer.MAX_VALUE;
                if(j<m-1) right = next[j+1];

                current[j] = matrix[i][j] + Math.min(left, Math.min(middle, right));
            }

            int[] temp = next;
            next = current;
            current = temp;
        }

        int min = Integer.MAX_VALUE;
        for(int i=0; i<m; i++){
            min = Math.min(min, next[i]);
        }

        return min;
    }

    // boolean isValid(int j, int[][] matrix){
    //     int m= matrix[0].length;

    //     return j>=0 && j<m;
    // }
}