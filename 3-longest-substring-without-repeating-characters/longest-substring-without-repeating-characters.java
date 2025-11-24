class Solution {
    public int lengthOfLongestSubstring(String str) {
        //your code goes here
        Set<Character> set = new HashSet<>();
        int left=0, right=0, maxLength=0;

        while(right <str.length()){
          //if not a valid window - shrink
          while(set.contains(str.charAt(right))){
            set.remove(str.charAt(left));
            ++left;
          }

          set.add(str.charAt(right));

          maxLength = Math.max(maxLength, right-left+1);
          ++right;
        }

        return maxLength;
    }
}