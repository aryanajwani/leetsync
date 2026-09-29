class Solution {
    public int countSubstrings(String str) {
        int n = str.length();

        int count=0;
        for(int i=0; i<n; i++){
            count += expandAroundCenter(str, i, i); // center is i

            count += expandAroundCenter(str, i, i+1); // center is between i & i+1
        }

        return count;
    }

    int expandAroundCenter(String str, int left, int right){
        int n = str.length();

        int count=0;
        while(left>=0 && right<n && str.charAt(left) == str.charAt(right)){
            count++;

            left--;
            right++;
        }

        return count;
    }
}