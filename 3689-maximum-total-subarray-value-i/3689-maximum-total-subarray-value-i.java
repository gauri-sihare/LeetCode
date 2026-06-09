class Solution {
    public long maxTotalValue(int[] nums, int k) {
        long max = Long.MIN_VALUE; 
        long min = Long.MAX_VALUE;
        for(int i=0 ; i< nums.length;i++){
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        return k*(max-min); //as we can choose same array as many times as we want.
    }
}