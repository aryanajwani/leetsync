class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int fresh=0;

        //row, column, time
        Queue<int[]> queue = new ArrayDeque<>();

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 1) fresh++;
                else if(grid[i][j] ==2) queue.add(new int[]{i, j, 0});
            }
        }

        int count=0;
        int[][] delta = {
            {0, -1}, {0, 1}, {1, 0}, {-1, 0}
        };

        int t=0;
        while(!queue.isEmpty()){
            int[] entry = queue.remove();
            int i = entry[0];
            int j = entry[1];
            t = entry[2];

            for(int[] del: delta){
                int i_ = i+del[0];
                int j_ = j+del[1];

                if(isValid(i_, j_, n, m) && grid[i_][j_]==1){
                    grid[i_][j_]=2;
                    queue.add(new int[]{i_, j_, t+1});
                    ++count;
                }
            }
        }

        if(count == fresh) return t;
        return -1;
    }

    boolean isValid(int row, int column, int n, int m){
        return row<n && row>=0 && column<m && column>=0;
    }
}