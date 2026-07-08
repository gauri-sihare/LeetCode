class Solution {
    int mod = 1000000007;

    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();

        // prefix sum of digits
        long[] presum = new long[n + 1];

        // concatenated value of non-zero digits
        long[] conval = new long[n + 1];

        // count of non-zero digits
        long[] count = new long[n + 1];

        // powers of 10
        long[] pow = new long[n + 1];

        pow[0] = 1;

        for (int i = 1; i <= n; i++) {
            int num = s.charAt(i - 1) - '0';

            presum[i] = (presum[i - 1] + num) % mod;

            if (num == 0) {
                conval[i] = conval[i - 1];
                count[i] = count[i - 1];
            } else {
                conval[i] = (conval[i - 1] * 10 + num) % mod;
                count[i] = count[i - 1] + 1;
            }

            pow[i] = (pow[i - 1] * 10) % mod;
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];

            long sum = (presum[right + 1] - presum[left] + mod) % mod;

            long leftPart = conval[left];
            long rightPart = conval[right + 1];

            int diff = (int) (count[right + 1] - count[left]);

            long power = pow[diff];

            long range = (rightPart - (leftPart * power) % mod + mod) % mod;

            ans[i] = (int) ((range * sum) % mod);
        }

        return ans;
    }
}