class Solution {
    public int lengthOfLongestSubstring(String str) {
        int hash[] = new int[128];
        int maxLength = 0;

        for(int i=0; i<str.length(); i++){
            for(int j=i; j<str.length(); j++){
                char chr = str.charAt(j);
                if(hash[chr] ==1){
                    //max I can get starting with this char
                    break;
                }

                maxLength = Math.max(maxLength, j-i+1);
                hash[chr] =1;
            }

            hash = new int[128];
        }

        return maxLength;
    }
}