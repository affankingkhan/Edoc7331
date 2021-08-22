import java.util.*;

class Solution {
    HashMap<Integer, Long> map;
    int MOD = 1000000007;
    public int solve(int n) {
        map = new HashMap<>();
        return (int) (recurse(0, n - 1) % MOD);
        // if(n == 0) return 1;

        // var dp = new long[n + 1];
        // dp[0] = dp[1] = 1L;

        // for (var i = 2; i <= n; i++)
        //     for (var j = 1; j <= i; j++) {
        //         long val = (dp[j - 1] % MOD) * (dp[i - j] % MOD);
        //         val %= MOD;
        //         dp[i] += val;

        //     }
        // return (int) (dp[n] % MOD);
    }

    private long recurse(int start, int end) {
        if (start >= end)
            return 1L;

        if (map.containsKey(end - start)) {
            return map.get(end - start);
        }

        long count = 0L;
        for (int i = start; i <= end; i++) {
            long left = recurse(start, i - 1) % MOD;
            long right = recurse(i + 1, end) % MOD;
            long p = (left * right) % MOD;
            count += p;
        }
        map.put(end - start, count);
        return count;
    }
}