// https://binarysearch.com/problems/Dice-Throw
import java.util.*;
class Solution {
    int mod = 1_000_000_007;
    public int solve(int n, int faces, int total) {
        return bottomUp(n, faces, total);
    }

    public int bottomUp(int n, int faces, int total) {
        int[][] dp = new int[n + 1][total + 1];
        dp[0][0] = 1;

        for (int dice = 1; dice <= n; dice++) {
            int min = dice;
            int max = dice * faces;
            max = Math.min(max, total);
            for (int sum = min; sum <= max; sum++) {
                int ans = 0;
                for (int i = 1; i <= faces; i++) {
                    int con = sum - i;
                    if (con < 0)
                        continue;
                    ans %= mod;
                    int subAns = dp[dice - 1][con] % mod;
                    ans += subAns;
                }
                dp[dice][sum] = ans;
            }
        }

        // for(int i =0; i <n+1; i++){
        //     System.out.println("With " + i + " dice");
        //     for(int num : dp[i]){
        //         System.out.print(num + " ");
        //     }
        //     System.out.println("");
        // }
        return dp[n][total] % mod;
    }
}