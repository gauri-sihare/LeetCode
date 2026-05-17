class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer , Integer> hm = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> hm.get(b) - hm.get(a));
        // max heap.
        for(int i =0; i< nums.length ;i++){
            hm.put(nums[i] , hm.getOrDefault(nums[i] , 0)+1);

        }
        pq.addAll(hm.keySet());

        int ans[] = new int[k];
        for(int i =0; i<k ;i++){
            ans[i] = pq.remove();

        }
        return ans;
    }
}