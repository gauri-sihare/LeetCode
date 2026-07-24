class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        HashSet<Integer> pairXor = new HashSet<>();
        HashSet<Integer> ans = new HashSet<>();

        // Store XOR of every pair
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                pairXor.add(nums[i] ^ nums[j]);
            }
        }

        // XOR each pair XOR with every element
        for (int x : pairXor) {
            for (int num : nums) {
                ans.add(x ^ num);
            }
        }

        // Triplets with repeated indices
        for (int num : nums) {
            ans.add(num);
        }

        return ans.size();
    }
}