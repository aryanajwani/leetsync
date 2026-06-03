class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int minTime =Integer.MAX_VALUE;

        int F = Integer.MAX_VALUE;
        for(int i=0; i<landStartTime.length; i++){
            F = Math.min(F, landStartTime[i] + landDuration[i]);
        }

        for(int i=0; i<waterStartTime.length; i++){
            minTime = Math.min(minTime, Math.max(F, waterStartTime[i])+waterDuration[i]);
        }

        F = Integer.MAX_VALUE;
        for(int i=0; i<waterStartTime.length; i++){
            F = Math.min(F, waterStartTime[i] + waterDuration[i]);
        }

        for(int i=0; i<landStartTime.length; i++){
            minTime = Math.min(minTime, Math.max(F, landStartTime[i])+landDuration[i]);
        }

        return minTime;
    }
}