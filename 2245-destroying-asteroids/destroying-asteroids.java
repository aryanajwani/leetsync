class Solution {
    public boolean asteroidsDestroyed(int m, int[] asteroids) {
        Arrays.sort(asteroids);
        long mass = m;

        for(int asteroid : asteroids){
            if(asteroid <= mass) mass+= asteroid;
            else return false;
        }

        return true;
    }
}