class Solution {
    public int maxScore(int[] arr, int k) {
        int leftSum=0, rightSum=0, maxSum=0;

        for(int i=0; i<=k-1; i++){
          leftSum += arr[i];
        }

        maxSum =leftSum;

        int right = arr.length-1;
        for(int i=k-1; i>=0; i--){
          leftSum -= arr[i];
          rightSum += arr[right];
          --right;

          maxSum = Math.max(maxSum, leftSum+rightSum);
        }


        return maxSum;
    }
}