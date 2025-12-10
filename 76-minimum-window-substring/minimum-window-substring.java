class Solution {
    public String minWindow(String str, String t) {
        if(str.length()< t.length())return "";

        char strChar[] = str.toCharArray();
        char tChar[] = t.toCharArray();

        int hash[] = new int[256];
        for(int i=0; i<t.length(); i++){
            hash[t.charAt(i)]++;
        }

        int left=0, right=0;
        int startIndex =-1;
        int minLength = Integer.MAX_VALUE;
        int count=0;

        while(right <strChar.length){
            char chr = strChar[right];

            if(hash[chr] >0) count++;
            hash[chr]--;

            //can be a window
            while(count == t.length()){
                if(right-left+1 < minLength){
                    minLength = right-left+1;
                    startIndex = left;
                }
                
                hash[strChar[left]]++;
                if (hash[strChar[left]] >0) count--;
                left++;
            }

            right++;
        }

        if(startIndex == -1) return "";
        return str.substring(startIndex, startIndex+minLength);
    }
}