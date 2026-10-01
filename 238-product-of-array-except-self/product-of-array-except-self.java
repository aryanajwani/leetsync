class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;

        int[] prefix = new int[n];
        int[] suffix = new int[n];

        int preProd=1;
        int suffProd=1;
        for(int i=0; i<n; i++){
            prefix[i] = preProd;
            preProd*= nums[i];

            suffix[n-1-i] = suffProd;
            suffProd *= nums[n-1-i];
        }

        int result[] = new int[n];
        for(int i=0; i<n; i++){
            result[i] = prefix[i]*suffix[i];
        }

        return result;
    }
}