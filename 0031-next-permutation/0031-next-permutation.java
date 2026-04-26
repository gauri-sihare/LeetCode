class Solution {
    public void nextPermutation(int[] nums) {
        int idx = -1;

        // Step 1: find breakpoint
        for(int i = nums.length - 2; i >= 0; i--) {
            if(nums[i] < nums[i + 1]) {
                idx = i;
                break;
            }
        }

        // Step 2: swap with next greater
        if(idx != -1) {
            for(int i = nums.length - 1; i > idx; i--) {
                if(nums[i] > nums[idx]) {
                    int temp = nums[i];
                    nums[i] = nums[idx];
                    nums[idx] = temp;
                    break;
                }
            }
        }

        // Step 3: reverse suffix
        reverse(nums, idx + 1, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while(end > start) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}