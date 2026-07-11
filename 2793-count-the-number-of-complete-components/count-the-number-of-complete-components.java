import java.util.*;

class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        // Step 1: Build the adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        int completeComponentsCount = 0;

        // Step 2: Traverse each component using BFS
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int nodeCount = 0;
                int totalEdges = 0;
                
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                visited[i] = true;

                while (!queue.isEmpty()) {
                    int curr = queue.poll();
                    nodeCount++;
                    totalEdges += adj.get(curr).size();

                    for (int neighbor : adj.get(curr)) {
                        if (!visited[neighbor]) {
                            visited[neighbor] = true;
                            queue.offer(neighbor);
                        }
                    }
                }

                // Step 3: Verify if the component is fully connected
                if (totalEdges == nodeCount * (nodeCount - 1)) {
                    completeComponentsCount++;
                }
            }
        }

        return completeComponentsCount;
    }
}
