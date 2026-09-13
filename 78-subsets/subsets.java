class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();

        solve(0, nums, new ArrayList<>(), result, set);

        return result;
    }

    void solve(int index, int[] nums, List<Integer> list, List<List<Integer>> result, Set<List<Integer>> set){

        if(index==nums.length){
            if(!set.contains(list)){
                set.add(new ArrayList(list));
                result.add(new ArrayList(list));
            }
            return;
        }

        list.add(nums[index]);
        solve(index+1, nums, list, result, set);

        list.removeLast();
        solve(index+1, nums, list, result, set);
    }
}