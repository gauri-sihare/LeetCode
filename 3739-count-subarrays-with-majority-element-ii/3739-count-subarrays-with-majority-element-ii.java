class Solution {
    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        int len = 2*n +2;
        
        long[] countAtSum = new long[len];
        long[] cumCount = new long[len];

        int idx = n+1;  //denoting mid idx of arr
        countAtSum[idx] = 1;
        cumCount[idx] =1;

        long ans =0;

        for(int num:nums){
            if(num == target){
                idx++;
            }else{
                idx--;
            }

            countAtSum[idx]++;
            ans += cumCount[idx-1];
            cumCount[idx] = countAtSum[idx] + cumCount[idx-1];
        }
        return ans;
    }
}