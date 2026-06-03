class RangeFreqQuery {

    int arr[];
    Map<Integer, List<Integer>> map;

    public RangeFreqQuery(int[] arr) {
        this.arr = arr;
        createMap();
    }
    
    public int query(int left, int right, int value) {
        List<Integer> indexes = map.get(value);

        if(indexes == null) return 0;
        
        return upperBound(right, indexes) - lowerBound(left, indexes);
    }

    public void createMap(){
        map = new HashMap<>();

        for(int i=0; i<arr.length; i++){
            if(!map.containsKey(arr[i])){
                map.put(arr[i], new ArrayList<>());
            }
            map.get(arr[i]).add(i);
        }
    }

    public int lowerBound(int target, List<Integer> arr){
        int low =0;
        int high = arr.size()-1;
        int mid;

        while(low <= high){
            mid = low +(high-low)/2;

            if(target <= arr.get(mid)) high = mid-1;
            else low = mid+1;
        }

        return low;
    }

    public int upperBound(int target, List<Integer> arr){
        int low=0;
        int high= arr.size()-1;
        int mid;

        while(low <= high){
            mid = low + (high-low)/2;

            if(target<arr.get(mid)) high = mid-1;
            else low = mid+1;
        }

        return low;
    }
}

/**
 * Your RangeFreqQuery object will be instantiated and called as such:
 * RangeFreqQuery obj = new RangeFreqQuery(arr);
 * int param_1 = obj.query(left,right,value);
 */