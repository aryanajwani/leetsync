class Solution {
    public int minimumCost(int[] arr) {
        Arrays.sort(arr);
        int cost =0;

        int n = arr.length;

        for(int i=arr.length-1; i>=0; i--){
            double k = (double)(n-i)/3;
            if(k%1==0) continue;

            cost += arr[i];
        }

        return cost;
    }
}


// 10 - 7, 4, 1


// i == n-3k
// n-i = 3k
// k == n-i/3