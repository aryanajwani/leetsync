class Solution {
    public int lastStoneWeightII(int[] arr) {
        int n = arr.length;
        int sum =0;
        for(int i=0; i<n; i++) sum += arr[i];

        int k =sum;
        boolean prev[] = new boolean[k+1];

        for(int i=0; i<n; i++) prev[0] = true;
        
        prev[arr[0]] = true;

        for(int i=1; i<n; i++){
            for(int target=k; target>=0; target--){
                
                boolean nottake = prev[target];

                boolean take = false;
                if(target>= arr[i]) take = prev[target-arr[i]];

                prev[target] = take || nottake;
            }
        }

        int min = Integer.MAX_VALUE;
        for(int s1=0; s1<=k/2; s1++){
            if(prev[s1] ==true){
                int s2 = sum -s1;

                min = Math.min(min, s2-s1);
            }
        }

        return min;
    }
}