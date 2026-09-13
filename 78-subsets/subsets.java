class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        solve(0, nums, new ArrayList<>(), result);

        return result;
    }

    void solve(int index, int[] nums, List<Integer> list, List<List<Integer>> result){

        if(index==nums.length){
            result.add(new ArrayList(list));
            return;
        }

        list.add(nums[index]);
        solve(index+1, nums, list, result);

        list.removeLast();
        solve(index+1, nums, list, result);
    }
}