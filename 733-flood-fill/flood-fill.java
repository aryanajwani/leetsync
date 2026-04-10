class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int visited[][]= new int[image.length][image[0].length];
        int oldColor = image[sr][sc];

        dfs(image, sr, sc, newColor, oldColor, visited);

        return image;
    }

    void dfs(int[][] image, int row, int column, int newColor, int oldColor, int[][] visited){
        image[row][column] = newColor;
        visited[row][column] =1;

        int delRow[] = {0, 0, 1, -1};
        int delColumn[] = {-1, 1, 0, 0};

        for(int i=0; i<4; i++){
            int newRow = row+delRow[i];
            int newColumn = column+delColumn[i];

            if(newRow>=0 && newRow<image.length && newColumn>=0 &&
            newColumn<image[0].length && image[newRow][newColumn] == oldColor && visited[newRow][newColumn]!=1){
                dfs(image, newRow, newColumn, newColor, oldColor, visited);
            }
        }
    }
}