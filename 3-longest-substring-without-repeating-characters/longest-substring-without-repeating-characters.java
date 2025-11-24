class Solution {
    public int lengthOfLongestSubstring(String str) {
        //your code goes here
        int hash[] = new int[256];
        int left=0, right=0, maxLength=0;

        while(right <str.length()){
          //if not a valid window - shrink
          while(hash[str.charAt(right)] == 1){
            hash[str.charAt(left)] =0;
            ++left;
          }

          hash[str.charAt(right)] =1;

          maxLength = Math.max(maxLength, right-left+1);
          ++right;
        }

        return maxLength;
    }
}