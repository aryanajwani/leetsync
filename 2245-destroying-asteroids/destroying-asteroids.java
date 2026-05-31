class Solution {
    public boolean asteroidsDestroyed(int m, int[] asteroids) {
        boolean found;
        long mass = m;

        int visited[] = new int[asteroids.length];

        do{
            found = false;
            for(int i=0; i<asteroids.length; i++){
                if(visited[i]!= 1 && asteroids[i] <= mass){
                    mass += asteroids[i];
                    visited[i] = 1;
                    found = true;
                }
            }
        } while(found);


        for(int i=0; i<visited.length; i++){
            if(visited[i] !=1) return false;
        }
        return true;
    }
}