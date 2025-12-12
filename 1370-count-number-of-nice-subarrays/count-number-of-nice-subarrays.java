class Solution {
    int func(int[] arr, int k){
        //returns the no of subarrays having odds <= k

        int left=0, right=0;
        int oddCount=0;
        int count=0;


        while(right < arr.length){
            if(arr[right] %2 !=0) oddCount++;

            while(oddCount > k){
                if(arr[left]%2 !=0) oddCount--;
                left++;
            }

            count += right-left+1;
            right++;
        }

        return count;
    }
    public int numberOfSubarrays(int[] arr, int k) {
        return func(arr, k) - func(arr, k-1);
    }
}