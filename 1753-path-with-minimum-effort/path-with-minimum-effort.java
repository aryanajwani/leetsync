class Solution {
    public int minimumEffortPath(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] distance = new int[n][m];
        for(int i=0; i<n; i++) Arrays.fill(distance[i], Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[2], b[2])
        );

        distance[0][0] = 0;
        pq.add(new int[]{0, 0, 0});

        int directions[][] = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

        while(!pq.isEmpty()){
            int[] node = pq.remove();

            int row = node[0];
            int column = node[1];
            int effort =  node[2];
            
            if(row == n-1 && column == m-1) return effort;

            if(effort > distance[row][column]) continue;

            for(int direction[] : directions){
                int nrow = row+ direction[0];
                int ncolumn = column + direction[1];

                if(isOuter(nrow, ncolumn, n, m)) continue;

                int neffort = Math.max(
                    effort, Math.abs(
                        grid[nrow][ncolumn]- grid[row][column]
                    )
                );


                if(neffort < distance[nrow][ncolumn]){
                    pq.add(new int[]{nrow, ncolumn, neffort});
                    distance[nrow][ncolumn] = neffort;
                }       
            }
        }

        return -1; // shouldnt reach here
    }

    boolean isOuter(int row, int column, int n, int m){
        if (row<0 || row>=n || column<0 || column>= m) return true;

        return false;
    }
}