class Solution {
    public int maxProduct(int[] arr) {
        //left anf right products
        int left = 1;
        int right =1;

        //left and right pointers
        int i=0;
        int j=arr.length-1;
        int max = Integer.MIN_VALUE;

        while(i <arr.length){
            left *= arr[i];
            right *= arr[j];

            max = Math.max(max, Math.max(left, right));

            if(left==0) left=1;
            if(right==0) right=1;

            i++;
            j--;
        }

        return max;
    }
}