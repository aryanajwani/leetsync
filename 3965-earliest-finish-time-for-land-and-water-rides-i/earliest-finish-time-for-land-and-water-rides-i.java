class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int minTime = Integer.MAX_VALUE;

        for(int i=0; i<landStartTime.length; i++){
            int landEndTime = landStartTime[i] + landDuration[i];

            int finalEndTime;
            for(int j=0; j<waterStartTime.length; j++){
                finalEndTime = Math.max(landEndTime, waterStartTime[j]) + waterDuration[j];

                minTime = Math.min(minTime, finalEndTime);
            }
        }

        for(int i=0; i<waterStartTime.length; i++){
            int waterEndTime = waterStartTime[i] + waterDuration[i];

            int finalEndTime;
            for(int j=0; j<landStartTime.length; j++){
                finalEndTime = Math.max(waterEndTime, landStartTime[j]) + landDuration[j];

                minTime = Math.min(minTime, finalEndTime);
            }
        }

        return minTime;
    }
}