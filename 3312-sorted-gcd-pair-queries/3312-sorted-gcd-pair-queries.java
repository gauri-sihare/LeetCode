import java.util.*;

class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {

        int max = 0;
        for (int x : nums) max = Math.max(max, x);

        // Frequency of each value
        int[] freq = new int[max + 1];
        for (int x : nums) freq[x]++;

        // divisible[g] = how many numbers are divisible by g
        long[] divisible = new long[max + 1];
        for (int g = 1; g <= max; g++) {
            for (int multiple = g; multiple <= max; multiple += g) {
                divisible[g] += freq[multiple];
            }
        }

        // exactPairs[g] = number of pairs whose gcd is exactly g
        long[] exactPairs = new long[max + 1];

        for (int g = max; g >= 1; g--) {
            long cnt = divisible[g];
            long pairs = cnt * (cnt - 1) / 2;

            for (int multiple = g + g; multiple <= max; multiple += g) {
                pairs -= exactPairs[multiple];
            }

            exactPairs[g] = pairs;
        }

        // Prefix counts over gcd values
        long[] prefix = new long[max + 1];
        for (int g = 1; g <= max; g++) {
            prefix[g] = prefix[g - 1] + exactPairs[g];
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            long k = queries[i] + 1; // queries are 0-indexed

            int lo = 1;
            int hi = max;

            while (lo < hi) {
                int mid = lo + (hi - lo) / 2;

                if (prefix[mid] >= k)
                    hi = mid;
                else
                    lo = mid + 1;
            }

            ans[i] = lo;
        }

        return ans;
    }
}