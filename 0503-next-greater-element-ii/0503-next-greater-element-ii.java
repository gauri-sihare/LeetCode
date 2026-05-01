class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> s = new Stack();
        //right sub array greates 
        int n = nums.length;
        int[] rge = new int[nums.length];
        for(int i = 2*nums.length-1; i>=0 ; i--){
            while(!s.isEmpty()  && nums[i%n] >= nums[s.peek()]){  
                s.pop();
            }
            if(s.isEmpty()){
                rge[i%n] = -1;
            }else{
                rge[i%n] = nums[s.peek()];
            }
            s.push(i%n);
        }
        //max of both
        return rge;

    }
}