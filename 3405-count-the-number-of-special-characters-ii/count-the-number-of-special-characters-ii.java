class Solution {
    public int numberOfSpecialChars(String word) {
        Map<Character, Integer> lastlower = new HashMap<>();
        Map<Character, Integer> firstupper = new HashMap<>();

        for(int i=0; i<word.length(); i++){
            char chr = word.charAt(i);

            if(Character.isLowerCase(chr)){
                lastlower.put(chr, i);
            }
            else{
                if(!firstupper.containsKey(Character.toLowerCase(chr))) firstupper.put(Character.toLowerCase(chr), i);
            }
        }

        int count =0;
        for(int i=0; i<26; i++){
            char chr = (char) ('a'+ i);
            if(lastlower.containsKey(chr) && firstupper.containsKey(chr)
            && lastlower.get(chr) < firstupper.get(chr)) ++count;
        }

        return count;
     }
}