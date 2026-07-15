class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1) return -1;

        int n = grid.length;
        int m  = grid[0].length;

        Queue<int[]> queue = new ArrayDeque<>();

        boolean[][] visited = new boolean[n][m];

        for(int i=0; i<visited.length; i++){

            for(int j=0; j<visited[0].length; j++){
                visited[i][j] = false;
            }
        }

        queue.add(new int[]{0, 0});
        visited[0][0] = true;

        int level=0;
        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i=0; i<size; i++){
                int[] cords = queue.remove();
                int row = cords[0];
                int column = cords[1];

                if(row==n-1 && column==m-1) return level+1;

                addNeighbours(row, column, queue, visited, grid);
            }

            ++level;
        }

        return -1;
    }

    void addNeighbours(int row, int column, Queue<int[]> queue, boolean[][] visited, int[][] grid){
        //add left right up down
        addIfPresent(row, column-1, queue, visited, grid);
        addIfPresent(row, column+1, queue, visited, grid);
        addIfPresent(row-1, column, queue, visited, grid);
        addIfPresent(row+1, column, queue, visited, grid);

        // add diagonals colck-wise
        addIfPresent(row-1, column+1, queue, visited, grid);
        addIfPresent(row+1, column+1, queue, visited, grid);
        addIfPresent(row+1, column-1, queue, visited, grid);
        addIfPresent(row-1, column-1, queue, visited, grid);
    }

    void addIfPresent(int row, int column, Queue<int[]> queue, boolean[][] visited, int[][] grid){
        if(row<0 || row>=visited.length || column<0 || column>= visited[0].length || grid[row][column] ==1 || visited[row][column])
            return;
        
        queue.add(new int[]{row, column});
        visited[row][column] = true;
    }
}