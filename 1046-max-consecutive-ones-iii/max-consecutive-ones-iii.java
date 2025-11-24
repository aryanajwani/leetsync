class Solution {
    public int longestOnes(int[] arr, int k) {

        int left =0, right =0;
        int count =0;
        int maxLength =0;


        while(right <arr.length){
            if(arr[right] == 0) ++count;

            //invalid window - shrink
            if(count > k){
                if(arr[left] == 0) --count;
                ++left;
            }

            //window valid
            maxLength = Math.max(maxLength, right-left+1);
            ++right;
        }

        return maxLength;
    }
}