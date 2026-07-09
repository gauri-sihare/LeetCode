class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        // g[i] will store the component identifier for node i
        int[] g = new int[n];
        int cnt = 0;
        
        // Since nums is sorted, adjacent items track connectivity breaks
        for (int i = 1; i < n; ++i) {
            if (nums[i] - nums[i - 1] > maxDiff) {
                cnt++; // Increment group ID if the gap is too large
            }
            g[i] = cnt;
        }
        
        // Process each query in O(1) time
        int m = queries.length;
        boolean[] answer = new boolean[m];
        for (int i = 0; i < m; ++i) {
            int u = queries[i][0];
            int v = queries[i][1];
            // If they belong to the same component group, a path exists
            answer[i] = (g[u] == g[v]);
        }
        
        return answer;
    }
}
