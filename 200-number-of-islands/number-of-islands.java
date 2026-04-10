class Solution {
    public int numIslands(char[][] grid) {
        int[][] visited = new int[grid.length][];
        for(int i=0; i<grid.length; i++){
            visited[i] = new int[grid[0].length];
        }
        int count=0;

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]=='1' && visited[i][j]!=1){
                    count++;
                    dfs(i, j, visited, grid);
                }
            }
        }

        return count;
    }

    void dfs(int row, int column, int[][] visited, char[][] grid){
        visited[row][column] =1;

        //check for neighbours and perform dfs on them

        //horizontal neighbours
        for(int delColumn=-1; delColumn<=1; delColumn++){
            int newColumn = column+delColumn;

            
            if(newColumn>=0 && newColumn<grid[0].length 
            && grid[row][newColumn]=='1' && visited[row][newColumn]!=1){
                dfs(row, newColumn, visited, grid);
            }
        }

        //vertical neighbours
        for(int delRow=-1; delRow<=1; delRow++){
            int newRow = row+delRow;

            if(newRow>=0 && newRow<grid.length && grid[newRow][column]=='1'
            && visited[newRow][column]!=1){
                dfs(newRow, column, visited, grid);
            }
        }
    }
}