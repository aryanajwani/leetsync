class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int max=-1;
        for(int i=0; i<nums.length; i++) max = Math.max(max, nums[i]);

        int low =1;
        int high = max;

        while(low<=high){
            int mid = low +(high-low)/2;

            if(canDivideWithin(mid, threshold, nums)){
                high = mid-1;
            }
            else low = mid+1;
        }

        return low;
    }

    boolean canDivideWithin(int divisor, int threshold, int[] nums){
        int sum=0;
        for(int i=0; i<nums.length; i++){
            sum += Math.ceil((double)nums[i] / divisor);

            if(sum> threshold) return false;
        }

        return true;
    }
}