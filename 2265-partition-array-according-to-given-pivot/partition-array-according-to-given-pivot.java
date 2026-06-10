class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int equal=0, greater=0;

        int arr[] = new int[nums.length];
        int index=0;

        for(int i=0; i<nums.length; i++){
            if(nums[i] <pivot) arr[index++] = nums[i];
            else if (nums[i] == pivot) ++equal;
            else ++greater;
        }

        for(int i=0; i<equal; i++) arr[index++] = pivot;

        for(int i=0; i<nums.length; i++){
            if(nums[i] >pivot) arr[index++] = nums[i];
        }

        return arr;
    }
}