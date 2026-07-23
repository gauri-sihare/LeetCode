class Solution {
    public int uniqueXorTriplets(int[] nums) {
       if(nums.length <= 2){
            return nums.length;
       }
       if(nums.length >= 3){
        int n = nums.length;
        int bits = Integer.toBinaryString(n).length();
        return (int)Math.pow(2 , bits);
       }
       return 0;
    }
}