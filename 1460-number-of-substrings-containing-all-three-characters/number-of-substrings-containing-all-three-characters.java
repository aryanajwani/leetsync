class Solution {
    public int numberOfSubstrings(String s) {
        char str[] = s.toCharArray();
        int lastSeen[] = new int[]{-1, -1, -1}; 
        int count =0;

        int right=0;

        while(right< str.length){
            lastSeen[str[right]-'a'] = right;

            int minLastSeen = Math.min(Math.min(lastSeen[0], lastSeen[1]), lastSeen[2]);

            //means we have a window
            if(minLastSeen!= -1) count+= minLastSeen+1;

            right++;
        }

        return count;
    }
}