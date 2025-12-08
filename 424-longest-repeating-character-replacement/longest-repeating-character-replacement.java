class Solution {
    public int characterReplacement(String str, int k) {
        //your code goes here
        int left=0, right=0;
        int majority =0;
        int maxLength =0;

        Map<Character, Integer> map = new HashMap<>();

        while(right <str.length()){
            char chr = str.charAt(right);

            map.put(chr, map.getOrDefault(chr, 0)+1);
            majority = Math.max(majority, map.get(chr));
            int changes = right-left+1 - majority;

            if(changes >k){
                //invalid window
                char popChar = str.charAt(left);
                map.put(popChar, map.get(popChar)-1);
                left++;
            }

            //valid window
            maxLength = Math.max(maxLength, right-left+1);
            right++;
        }

        return maxLength;
    }
}