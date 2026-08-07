class Solution {
    public int[] arrayRankTransform(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        int[] arr = new int[nums.length];
        for(int i=0; i<arr.length; i++){
            arr[i] = nums[i];
        }

        Arrays.sort(arr);

        int rank =1;
        for(int i=0; i<arr.length; i++){
            while(i+1<arr.length && arr[i] == arr[i+1]) ++i;
            map.put(arr[i], rank++);
        }

        for(int i=0; i<arr.length; i++){
            arr[i] = map.get(nums[i]);
        }

        return arr;
    }
}