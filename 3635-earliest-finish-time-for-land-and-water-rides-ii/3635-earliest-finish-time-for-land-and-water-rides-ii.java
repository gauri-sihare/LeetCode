class Solution {

    public int earliestFinishTime(int[] landStartTime, int[] landDuration,
                                  int[] waterStartTime, int[] waterDuration) {

        long ans1 = solve(landStartTime, landDuration,
                          waterStartTime, waterDuration);

        long ans2 = solve(waterStartTime, waterDuration,
                          landStartTime, landDuration);

        return (int)Math.min(ans1, ans2);
    }

    private long solve(int[] Astart, int[] Adur,
                       int[] Bstart, int[] Bdur) {

        int m = Bstart.length;

        long[][] rides = new long[m][2];

        for (int i = 0; i < m; i++) {
            rides[i][0] = Bstart[i];
            rides[i][1] = Bdur[i];
        }

        Arrays.sort(rides, (a, b) -> Long.compare(a[0], b[0]));

        long[] starts = new long[m];

        for (int i = 0; i < m; i++) {
            starts[i] = rides[i][0];
        }

        // prefix minimum duration
        long[] pref = new long[m];

        for (int i = 0; i < m; i++) {
            if (i == 0) {
                pref[i] = rides[i][1];
            } else {
                pref[i] = Math.min(pref[i - 1], rides[i][1]);
            }
        }

        // suffix minimum of (start + duration)
        long[] suff = new long[m];

        for (int i = m - 1; i >= 0; i--) {

            long val = rides[i][0] + rides[i][1];

            if (i == m - 1) {
                suff[i] = val;
            } else {
                suff[i] = Math.min(suff[i + 1], val);
            }
        }

        long ans = Long.MAX_VALUE;

        for (int i = 0; i < Astart.length; i++) {

            long finish = 1L * Astart[i] + Adur[i];

            int idx = upperBound(starts, finish);

            // start <= finish
            if (idx > 0) {
                ans = Math.min(ans, finish + pref[idx - 1]);
            }

            // start > finish
            if (idx < m) {
                ans = Math.min(ans, suff[idx]);
            }
        }

        return ans;
    }

    private int upperBound(long[] arr, long target) {

        int left = 0;
        int right = arr.length;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}