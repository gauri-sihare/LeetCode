import java.util.*;

class Solution {
    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int[][] ord = new int[n][2];
        for (int i = 0; i < n; i++) {
            ord[i][0] = nums[i];
            ord[i][1] = i;
        }

        Arrays.sort(ord, (a, b) -> Integer.compare(a[0], b[0]));

        int[] pos = new int[n];
        int[] comp = new int[n];

        int cid = 0;
        for (int i = 0; i < n; i++) {
            if (i > 0 && ord[i][0] - ord[i - 1][0] > maxDiff) {
                cid++;
            }
            pos[ord[i][1]] = i;
            comp[ord[i][1]] = cid;
        }

        int[] next = new int[n];
        int r = 0;
        for (int l = 0; l < n; l++) {
            while (r + 1 < n && ord[r + 1][0] - ord[l][0] <= maxDiff) {
                r++;
            }
            next[l] = r;
        }

        int LOG = 20;
        int[][] up = new int[LOG][n];
        for (int i = 0; i < n; i++) {
            up[0][i] = next[i];
        }

        for (int k = 1; k < LOG; k++) {
            for (int i = 0; i < n; i++) {
                up[k][i] = up[k - 1][up[k - 1][i]];
            }
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];

            if (u == v) {
                ans[i] = 0;
                continue;
            }

            if (comp[u] != comp[v]) {
                ans[i] = -1;
                continue;
            }

            int left = pos[u];
            int right = pos[v];
            if (left > right) {
                int temp = left;
                left = right;
                right = temp;
            }

            int cur = left;
            int jumps = 0;

            for (int k = LOG - 1; k >= 0; k--) {
                if (up[k][cur] < right) {
                    cur = up[k][cur];
                    jumps += 1 << k;
                }
            }

            ans[i] = jumps + 1;
        }

        return ans;
    }
}