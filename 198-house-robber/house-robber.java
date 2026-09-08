class Solution {
    public int rob(int[] arr) {
        int n = arr.length;

        int next = arr[n-1];
        int nextnext = -1;

        for(int i=n-2; i>=0; i--){
            int skip = next;

            int take= (nextnext!=-1)? arr[i]+nextnext : arr[i];

            int current = Math.max(skip, take);

            nextnext = next;
            next = current;
        }

        return next;
    }
}