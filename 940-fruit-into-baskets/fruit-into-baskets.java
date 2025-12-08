class Solution {
    public int totalFruit(int[] arr) {
        int right=0, left =0;
        Map<Integer, Integer> map = new HashMap<>();
        int max =0;

        while(right< arr.length){
            map.put(arr[right], right);

            if(map.size()> 2){
                left = Collections.min(map.values())+1;
                map.remove(arr[left-1]);
            }

            max = Math.max(max, right-left+1);
            ++right;
        }

        return max;
    }
}