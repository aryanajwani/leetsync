class Solution {
    public String longestPalindrome(String str) {
        int n = str.length();

        int max= -1;
        int right =-1, left=-1;
        for(int i=0; i<n; i++){
            int len1 = expandAroundCenter(str, i, i); // center is i
            int len2 = expandAroundCenter(str, i, i+1); // center is between i & i+1

            int len = Math.max(len1, len2);
            if(len > max){
                max = len;

                if(len%2==0){
                    right = i +len/2;
                    left = i- (len/2-1);
                }
                else{
                    left = i - (len-1)/2;
                    right = i+ (len-1)/2;
                }
            }
        }

        return str.substring(left, right+1);
    }

    int expandAroundCenter(String str, int left, int right){
        int n = str.length();

        while(left>=0 && right<n){
            if(str.charAt(left) != str.charAt(right)) break;

            --left;
            ++right;
        }

        return right-left-1;
    }
}