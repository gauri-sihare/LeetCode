class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0; i< nums.length ; i++){
            hm.put(nums[i] , i);
        }
        for(int i=0; i< nums.length; i++){
            int idx1= i;
            int idx2 = 0;
            int getthenum = target - nums[i];
            if(hm.containsKey(getthenum) && hm.get(getthenum) != i){
                 idx2 = hm.get(getthenum);
                if(idx2 != -1){
                    res[0] = idx1;
                    res[1] = idx2;
                }
            }
        }
        return res;
    }
}