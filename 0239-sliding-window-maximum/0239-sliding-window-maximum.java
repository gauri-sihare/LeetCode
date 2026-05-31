class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n= nums.length;
        Deque<Integer> dq = new ArrayDeque<>();
        int res[] = new int[n-k+1];
        //make first win dq
        for(int i=0; i<k ; i++){
            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]){
                dq.pollLast();
            }
            dq.offerLast(i);
        }
        res[0] = nums[dq.peekFirst()];
        // makking it for remaining
        for(int i =k; i<n ;i++){
            if(dq.peekFirst() <= i-k ){  // handling the case when first idx in dq < than the curr idx 
                dq.pollFirst();
            }
            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i] ){
                dq.pollLast();          //remove all small element in last
            }
            dq.offerLast(i);
            res[i-k+1] = nums[dq.peekFirst()];  
        }
        return res;
    }
}