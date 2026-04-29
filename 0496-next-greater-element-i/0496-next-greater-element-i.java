class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        Stack<Integer> s = new Stack<>();

        for(int i = nums2.length-1; i>=0 ;i--){
            while(!s.isEmpty() && nums2[i] > s.peek()){
                s.pop();
            }
            if(s.isEmpty()){
                hm.put(nums2[i] , -1);
            }else{
                hm.put(nums2[i] , s.peek());
            }
            s.push(nums2[i]);
        }
        int [] res = new int[nums1.length];
        for(int i =0; i< nums1.length; i++){
            res[i] = hm.get(nums1[i]);
        }
        return res;
    }
}