//toughhhhhhhhhhh
class Solution {
    static final long MOD = 1_000_000_007L;

    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;
        int sz = 2 * m;

        long[][] T = new long[sz][sz];

        // down(i) -> up(j), j < i
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < i; j++) {
                T[m + j][i] = 1;
            }
        }

        // up(i) -> down(j), j > i
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                T[j][m + i] = 1;
            }
        }

        long[][] P = matPow(T, n - 1);

        long[] start = new long[sz];
        for (int i = 0; i < sz; i++) {
            start[i] = 1;
        }

        long ans = 0;

        for (int i = 0; i < sz; i++) {
            long cur = 0;
            for (int j = 0; j < sz; j++) {
                cur = (cur + P[i][j] * start[j]) % MOD;
            }
            ans = (ans + cur) % MOD;
        }

        return (int) ans;
    }

    private long[][] matPow(long[][] A, long exp) {
        int n = A.length;

        long[][] res = new long[n][n];
        for (int i = 0; i < n; i++) {
            res[i][i] = 1;
        }

        while (exp > 0) {
            if ((exp & 1) == 1) {
                res = multiply(res, A);
            }
            A = multiply(A, A);
            exp >>= 1;
        }

        return res;
    }

    private long[][] multiply(long[][] A, long[][] B) {
        int n = A.length;
        long[][] C = new long[n][n];

        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                if (A[i][k] == 0) continue;

                long aik = A[i][k];

                for (int j = 0; j < n; j++) {
                    if (B[k][j] == 0) continue;

                    C[i][j] = (C[i][j] + aik * B[k][j]) % MOD;
                }
            }
        }

        return C;
    }
}