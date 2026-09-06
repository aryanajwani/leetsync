class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for (int pile : piles) {
            if (pile > max) {
                max = pile;
            }
        }

        if(h==piles.length) return max;

        int low = 1;
        int high = max;

        while(low <= high){
            int mid = low + (high-low)/2;

            if(canEat(mid, h, piles)) high = mid-1;
            else low = mid+1;
        }

        return low;
    }

    boolean canEat(int time, int h, int[] piles){
        long t=0;
        for(int i=0; i<piles.length; i++){
            t += Math.ceil((double)piles[i]/time);
        }

        return t <= h;
    }
}