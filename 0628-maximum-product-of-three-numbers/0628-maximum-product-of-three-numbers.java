class Solution {
    public int maximumProduct(int[] nums) {

        // Max Heap
        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>(Collections.reverseOrder());

        // Min Heap
        PriorityQueue<Integer> minHeap =
                new PriorityQueue<>();

        for (int num : nums) {
            maxHeap.offer(num);
            minHeap.offer(num);
        }

        // 3 largest
        int largest1 = maxHeap.poll();
        int largest2 = maxHeap.poll();
        int largest3 = maxHeap.poll();

        // 2 smallest
        int smallest1 = minHeap.poll();
        int smallest2 = minHeap.poll();

        int ans1 = largest1 * largest2 * largest3;
        int ans2 = smallest1 * smallest2 * largest1;

        return Math.max(ans1, ans2);
    }
}