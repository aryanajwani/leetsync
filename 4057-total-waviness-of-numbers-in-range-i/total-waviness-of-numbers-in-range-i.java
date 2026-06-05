class Solution {
    public int totalWaviness(int num1, int num2) {
        int count=0;
        for(int i=num1; i<=num2; i++){
            count += getWaviness(i);
        }

        return count;
    }


    int getWaviness(int num){
        if(num==0 || num/10 <2) return 0;

        int low =-1;
        int mid =-1;
        int high=-1;

        int peaks=0, valleys=0;
        while(num>0){
            int digit = num%10;

            if(high ==-1){
                high = digit; continue;
            }

            if(mid==-1){ 
                mid = digit; continue;
            }

            low =digit;

            if(low<mid && mid>high) ++peaks;
            else if (low> mid && mid<high) ++ valleys;

            high = mid;
            mid = low;

            num/=10;
        }

        return peaks+valleys;
    }
}