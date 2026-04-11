class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] isRotten = new boolean[grid.length][grid[0].length];
        int total=0;


        //add intitial rotten to the queue
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] !=0) total++;
                if(grid[i][j] == 2){
                    queue.add(new int[]{i, j});
                    isRotten[i][j] = true;
                }
            }
        }

        return bfs(grid, queue, isRotten, total);

    }


    int bfs(int[][] grid, Queue<int[]> queue, boolean[][] isRotten, int total){
        
        int time =0;
        int rotten=0;

        while(!queue.isEmpty()){
            int size = queue.size();
            rotten+= size;
            boolean didSpread = false;

            for(int i=0; i<size; i++){
                int[] orange = queue.remove();
                int row = orange[0];
                int column = orange[1];

                int delRow[] = {-1, 1, 0, 0};
                int delColumn[] = {0, 0, -1, 1};

                for(int j=0; j<4; j++){
                    int nRow = row + delRow[j];
                    int nColumn = column + delColumn[j];

                    if(isValidIndex(nRow, nColumn, grid) && grid[nRow][nColumn]==1 && !isRotten[nRow][nColumn]){
                        queue.add(new int[]{nRow, nColumn});
                        isRotten[nRow][nColumn] = true;
                        didSpread = true;
                    }
                }
            }

            if(didSpread) time++;
        }

        return (total == rotten)? time: -1;
    }

    boolean isValidIndex(int row, int column, int[][] grid){
        return row>=0 && row<grid.length && column>=0 && column<grid[0].length;
    }
}