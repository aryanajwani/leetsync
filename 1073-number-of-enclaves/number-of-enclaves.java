class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];

        for(int j=0; j<m; j++){
            if(grid[0][j]==1 && !visited[0][j]){
                bfs(0, j, visited, grid);
            }
        }

        for(int i=0; i<n; i++){
            if(grid[i][m-1]==1 && !visited[i][m-1]){
                bfs(i, m-1, visited, grid);
            }
        }

        for(int j=0; j<m; j++){
            if(grid[n-1][j]==1 && !visited[n-1][j]){
                bfs(n-1, j, visited, grid);
            }
        }

        for(int i=0; i<n; i++){
            if(grid[i][0]==1 && !visited[i][0]){
                bfs(i, 0, visited, grid);
            }
        }

        int count=0;
        for(int i=1; i<n-1; i++){
            for(int j=1; j<m-1; j++){
                if(grid[i][j]==1 && !visited[i][j]){
                    //a land not visited
                    count++;
                }
            }
        }

        return count;
    }

    void bfs(int row, int column, boolean[][] visited, int[][] grid){
        Queue<int[]> queue = new ArrayDeque<>();

        queue.add(new int[]{row, column});
        visited[row][column] = true;

        while(!queue.isEmpty()){
            int[] element = queue.remove();
            row = element[0];
            column = element[1];

            int[] delRow = new int[]{-1, 1, 0, 0};
            int[] delColumn = new int[]{0, 0, -1, 1};


            for(int i=0; i<4; i++){
                int nRow = row+delRow[i];
                int nColumn = column+delColumn[i];

                if(isValidIndex(nRow, nColumn, grid)){
                    if(grid[nRow][nColumn]== 1 && !visited[nRow][nColumn]){
                        visited[nRow][nColumn] = true;
                        queue.add(new int[]{nRow, nColumn});
                    }
                }
            }
        }         
    }

    boolean isValidIndex(int row, int column, int[][] grid){
        return row>=0 && row<grid.length && column>=0 && column<grid[0].length;
    }
}