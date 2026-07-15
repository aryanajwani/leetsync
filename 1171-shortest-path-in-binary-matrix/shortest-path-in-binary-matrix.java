class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1) return -1;

        int n = grid.length;

        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][n];

        queue.add(new int[]{0, 0});
        visited[0][0] = true;

        int level=0;
        int[][] directions = {
            {-1, -1}, {0, -1}, {1, -1},
            {-1, 1}, {0, 1}, {1, 1},
            {-1, 0}, {1, 0}
        };

        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i=0; i<size; i++){
                int[] cords = queue.remove();
                int row = cords[0];
                int column = cords[1];

                if(row==n-1 && column==n-1) return level+1;

                for(int[] direction : directions){
                    int nrow = row+ direction[0];
                    int ncolumn = column+direction[1];

                    if(isOuter(nrow, ncolumn, n)) continue;

                    if(grid[nrow][ncolumn] ==1 || visited[nrow][ncolumn]) continue;

                    queue.add(new int[]{nrow, ncolumn});
                    visited[nrow][ncolumn] = true; 
                }
            }

            ++level;
        }

        return -1;
    }

    boolean isOuter(int row, int column, int n){
        if (row<0 || row>=n || column<0 || column>= n) return true;

        return false;
    }

    // void addNeighbours(int row, int column, Queue<int[]> queue, boolean[][] visited, int[][] grid){
    //     //add left right up down
    //     addIfPresent(row, column-1, queue, visited, grid);
    //     addIfPresent(row, column+1, queue, visited, grid);
    //     addIfPresent(row-1, column, queue, visited, grid);
    //     addIfPresent(row+1, column, queue, visited, grid);

    //     // add diagonals colck-wise
    //     addIfPresent(row-1, column+1, queue, visited, grid);
    //     addIfPresent(row+1, column+1, queue, visited, grid);
    //     addIfPresent(row+1, column-1, queue, visited, grid);
    //     addIfPresent(row-1, column-1, queue, visited, grid);
    // }

    // void addIfPresent(int row, int column, Queue<int[]> queue, boolean[][] visited, int[][] grid){
    //     if(row<0 || row>=visited.length || column<0 || column>= visited[0].length || grid[row][column] ==1 || visited[row][column])
    //         return;
        
    //     queue.add(new int[]{row, column});
    //     visited[row][column] = true;
    // }
}