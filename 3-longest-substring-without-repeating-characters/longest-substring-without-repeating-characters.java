class Solution {
    public int lengthOfLongestSubstring(String str) {
        //your code goes here
        int lastSeen[] = new int[128];
        
        int left=0, right=0, maxLength=0;
        Arrays.fill(lastSeen, -1);

        while(right <str.length()){
            char chr = str.charAt(right);

            //if not a valid window - shrink
            if(lastSeen[chr] >= left){
                left = lastSeen[chr]+1;
          }

          lastSeen[chr] = right;

          maxLength = Math.max(maxLength, right-left+1);
          ++right;
        }

        return maxLength;
    }
}