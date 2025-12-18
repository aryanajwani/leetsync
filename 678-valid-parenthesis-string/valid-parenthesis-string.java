class Solution {
    public boolean checkValidString(String str) {
         int n= str.length();

        int min=0, max=0;
        for(int i=0; i<n; i++){
            char chr = str.charAt(i);

            if(chr =='('){
                min++;
                max++;
            }

            else if(chr == ')'){
                min--;
                max--;
            }

            else {
                min--;
                max++;
            }


            if(min <0) min =0;
            if(max <0) return false;
        }

        return min==0;
    }
}