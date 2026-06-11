class Solution {
    static final int MOD = 1_000_000_007;

    public int assignEdgeWeights(int[][] edges) {
        int n = edges.length + 1;

        List<Integer>[] graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] e : edges) {   // int[] e, not int e
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        int maxDepth = dfs(1, 0, graph);

        long ans = 1;
        for (int i = 1; i < maxDepth; i++) {
            ans = (ans * 2) % MOD;
        }

        return (int) ans;
    }

    private int dfs(int node, int parent, List<Integer>[] graph) {
        int depth = 0;

        for (int nxt : graph[node]) {
            if (nxt != parent) {
                depth = Math.max(depth, 1 + dfs(nxt, node, graph));
            }
        }

        return depth;
    }
}