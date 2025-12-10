class Solution {
    public String minWindow(String str, String t) {
        int hash[] = new int[256];
        for(int i=0; i<t.length(); i++){
            hash[t.charAt(i)]++;
        }


        int left=0, right=0;
        int startIndex =-1;
        int minLength = Integer.MAX_VALUE;
        int count=0;

        while(right <str.length()){
            char chr = str.charAt(right);

            if(hash[chr] >0) count++;
            hash[chr]--;

            //can be a window
            while(count == t.length()){
                if(right-left+1 < minLength){
                    minLength = right-left+1;
                    startIndex = left;
                }
                
                hash[str.charAt(left)]++;
                if (hash[str.charAt(left)] >0) count--;
                left++;
            }

            right++;
        }

        if(startIndex == -1) return "";
        return str.substring(startIndex, startIndex+minLength);
    }
}