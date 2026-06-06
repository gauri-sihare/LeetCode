class Solution {
    public int[] leftRightDifference(int[] nums) {
        int rS =0;
        int lS =0;
        int n = nums.length;
        for(int i =0; i< n ;i++){
            rS += nums[i];
        }
        for(int i=0; i< n;i++){
            int value = nums[i];
            rS -= nums[i];
            nums[i] = Math.abs(lS - rS);
            lS += value;
        }
        return nums;
    }
}