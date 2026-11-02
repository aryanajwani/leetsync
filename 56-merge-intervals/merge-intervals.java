class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, 
            (p, q) -> Integer.compare(p[0], q[0])
        );

        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);


        for(int i=1; i<intervals.length; i++){
            int[] last = list.get(list.size()-1);

            //merge
            if(last[1] >= intervals[i][0]){
                last[1] = Math.max(intervals[i][1], last[1]);
            }
            else list.add(intervals[i]);
        }

        return list.toArray(new int[0][]);
    }
}