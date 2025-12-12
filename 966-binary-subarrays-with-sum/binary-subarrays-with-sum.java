class Solution {

    int numSubarrayLesserEqualSum(int arr[], int goal){
        if(goal == -1) return 0;

        int left=0, right=0;
        int sum =0;
        int count=0;

        while(right < arr.length){
            sum += arr[right];

            while(sum > goal){
                sum -= arr[left];
                left++;
            }

            count += right-left+1;
            right++;
        }

        return count;
    }
    public int numSubarraysWithSum(int[] arr, int goal) {
        return numSubarrayLesserEqualSum(arr, goal) - numSubarrayLesserEqualSum(arr, goal-1);
    }
}