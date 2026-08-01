class Solution {
    public int countValidPrefixes(String s) {
        int z=0;
        int o=0;

        int count=0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '0') z++;
            else o++;

            if(i%2==1){
                if(z==o) count++;
            }
            else {
                if(Math.abs(z-o) ==1) count++;
            }
        }

        return count;
    }
}