class Solution {
    
    public int lengthOfLongestSubstring(String str) {
        int[] hash = new int[256];
        int n = str.length();

        int i =0;
        int j=0;
        int max = 0;
        while(i<n){
            char chr = str.charAt(i);
            hash[(int)chr]++;

            while(hash[(int) chr] >1){
                hash[(int) str.charAt(j)]--;
                j++;
            }

            max = Math.max(max, i-j+1);
            i++;
        }

        return max;
    }
}