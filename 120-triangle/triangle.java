class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();

        int[] next = new int[n];
        int[] current = new int[n];

        //set base cases for the last row
        for(int j=0; j<n; j++) next[j] = triangle.get(n-1).get(j);

        for(int i=n-2; i>=0; i--){
            for(int j=0; j<=i; j++){
                int left = next[j];
                int right = next[j+1];

                current[j] = triangle.get(i).get(j) + Math.min(left, right);
            }

            int[] temp = next;
            next = current;
            current = temp;
        }
        return next[0];
    }
}

// 0
// 01
// 012
// 0123
