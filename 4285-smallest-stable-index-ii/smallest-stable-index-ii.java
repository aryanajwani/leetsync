class Solution {
    public int firstStableIndex(int[] arr, int k) {
        int n = arr.length;

        int min[] = new int[n];
        min[n-1] = arr[n-1];

        for(int i=n-2; i>=0; i--){
            min[i] = Math.min(min[i+1], arr[i]);
        }

        int max = -1;
        for(int i=0; i<n; i++){
            max = Math.max(max, arr[i]);

            if((max - min[i]) <=k)  return i;
        }

        return -1;
    }
}