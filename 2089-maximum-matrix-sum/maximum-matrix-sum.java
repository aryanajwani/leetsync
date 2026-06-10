class Solution {
    public long maxMatrixSum(int[][] arr) {
        int min = Integer.MAX_VALUE;
        long sum =0;
        int neg=0;

        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                if(arr[i][j] > 0){
                    sum += arr[i][j];
                    if(arr[i][j] < min) min = arr[i][j];
                } else{
                    int abs  = -1*arr[i][j];
                    sum += abs;
                    if (abs < min) min = abs;

                    ++neg;
                }
            }
        }

        // System.out.println(sum);
        // System.out.println(neg);
        // System.out.println(min);


        if(neg%2 == 0) return sum;
        else return (sum-2*min);
    }
}