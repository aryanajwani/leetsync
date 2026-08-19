class Solution {
    public int swimInWater(int[][] arr) {
        int n = arr.length;

        //i, j, max encoutered till now
        PriorityQueue<int[]> pq= new PriorityQueue<>(
            (a, b) -> Integer.compare(a[2], b[2])
        );

        pq.add(new int[]{0, 0, arr[0][0]});

        boolean visited[][] = new boolean[n][n];

        while(!pq.isEmpty()){
            int[] node = pq.remove();

            int i = node[0];
            int j = node[1];
            int max = node[2];

            visited[i][j] = true;
            
            if(i==n-1 && j==n-1) return max;

            int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            for(int[] dir : directions){
                int nRow = i +dir[0];
                int nColumn = j +dir[1];

                if(isValid(nRow, nColumn, n) && !visited[nRow][nColumn]){
                    pq.add(new int[]{nRow, nColumn, Math.max(max, arr[nRow][nColumn])});
                }
            }
        }

        return -1;
    }

    boolean isValid(int row, int column, int n){
        return row>=0 && row<n && column>=0 && column<n;
    }
}