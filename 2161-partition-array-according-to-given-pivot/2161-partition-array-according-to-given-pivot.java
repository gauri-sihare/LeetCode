class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        ArrayList<Integer> bef = new ArrayList<>();
        ArrayList<Integer> piv = new ArrayList<>();
        ArrayList<Integer> aft = new ArrayList<>();

        for(int i =0; i< nums.length; i++){
            if(nums[i] < pivot){
                bef.add(nums[i]);
            }
            else if(nums[i] > pivot){
                aft.add(nums[i]);
            }else{
                piv.add(nums[i]);
            }
        }
        int idx =0;
        int[] res = new int[nums.length];
        for(int i=0; i< bef.size();i++){
            res[idx]= bef.get(i);
            idx++;
        }
        for(int i= 0; i< piv.size() ;i++){
            res[idx] = piv.get(i);
            idx++;
        }
        for(int i=0; i<aft.size() ;i++){
            res[idx] = aft.get(i);
            idx++;
        }
        return res;
    }
}