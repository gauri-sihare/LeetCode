class Solution {
    public int majorityElement(int[] nums) {
        int majority = nums[0];
        int votes = 1;

        for(int i = 1; i<=nums.length -1 ; i++){
            if(votes==0){
                majority = nums[i];
                votes++;
            }
            else if(majority == nums[i]){
                votes++;
            }
            else{      // votes!=0 && majority != nums[i]
                 votes--;
            }
        }
        return majority;
    }
}