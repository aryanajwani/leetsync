class Solution {
    public int numberOfSubstrings(String s) {
        char str[] = s.toCharArray();
        int countA=1, countB=1, countC=1;
        int count =0;

        int right=0, left=0;

        while(right< str.length){
            if(str[right]=='a')  countA--;
            else if(str[right] == 'b')  countB--;
            else if(str[right] == 'c')  countC--;
            
            while(countA<=0 && countB<=0 && countC<=0){
                count+= str.length-right;

                if(str[left]=='a')  countA++;
                else if(str[left] == 'b')  countB++;
                else if(str[left] == 'c')  countC++;

                left++;
            }

            right++;
        }

        return count;
    }
}