class Solution {
    public int subarraySum(int[] arr, int k) {
        // preSum -> freq
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int preSum = 0;

        int count=0;

        for(int i=0; i<arr.length; i++){
            preSum += arr[i];

            if (map.containsKey(preSum-k)) count += map.get(preSum-k);

            map.put(preSum, map.getOrDefault(preSum, 0)+1);
        }

        return count;
    }
}
 


//  1 3 -1 5 4 2 2 6  k=8

// preSum - x = k