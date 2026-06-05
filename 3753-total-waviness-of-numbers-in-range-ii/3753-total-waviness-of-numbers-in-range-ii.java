class Solution {

    Map<String, long[]> map;

    public long totalWaviness(long num1, long num2) {
        return getWave(num2) - getWave(num1 - 1);
    }

    long getWave(long num) {

        map = new HashMap<>();

        String str = Long.toString(num);

        if (str.length() < 3) {
            return 0;
        }

        long[] ans = helper(str, 0, true, -1, -1, true);

        return ans[1];
    }

    long[] helper(String str,
                  int idx,
                  boolean isBound,
                  int twoBefore,
                  int oneBefore,
                  boolean isLeadingZero) {

        if (idx == str.length()) {
            return new long[]{1, 0};
        }

        String key = idx + "#" + isBound + "#" +
                     twoBefore + "#" + oneBefore + "#" + isLeadingZero;

        if (map.containsKey(key)) {
            return map.get(key);
        }

        int upper;

        if (isBound) {
            upper = str.charAt(idx) - '0';
        } else {
            upper = 9;
        }

        long totalCount = 0;
        long totalWaves = 0;

        for (int digit = 0; digit <= upper; digit++) {

            long wave = 0;

            int nextTwoBefore;
            int nextOneBefore;

            if (isLeadingZero) {

                nextTwoBefore = -1;

                if (digit == 0) {
                    nextOneBefore = -1;
                } else {
                    nextOneBefore = digit;
                }

            } else {

                nextTwoBefore = oneBefore;
                nextOneBefore = digit;

                if (twoBefore >= 0 && oneBefore >= 0) {

                    boolean peak =
                            oneBefore > twoBefore &&
                            oneBefore > digit;

                    boolean valley =
                            oneBefore < twoBefore &&
                            oneBefore < digit;

                    if (peak || valley) {
                        wave = 1;
                    }
                }
            }

            boolean nextBound =
                    isBound && (digit == upper);

            boolean nextLeadingZero =
                    isLeadingZero && (digit == 0);

            long[] sub = helper(
                    str,
                    idx + 1,
                    nextBound,
                    nextTwoBefore,
                    nextOneBefore,
                    nextLeadingZero
            );

            totalCount += sub[0];

            totalWaves += sub[1] + (sub[0] * wave);
        }

        long[] result = new long[]{totalCount, totalWaves};

        map.put(key, result);

        return result;
    }
}