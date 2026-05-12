class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>() , nums, 0);
        return res;
    }

    public void backtrack(List<List<Integer>>resultset, List<Integer>temp , int[]nums, int start ){
        resultset.add(new ArrayList<Integer>(temp));
        
        for(int i =start; i< nums.length; i++){
            temp.add(nums[i]);
             backtrack(resultset , temp , nums , i+1);
             temp.remove(temp.size()-1);

        }
    }
}