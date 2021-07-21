// https://binarysearch.com/problems/Dice-Throw
import java.util.*;
class Solution {
    int[][] memo;
    int mod = 1_000_000_007;
    public int solve(int n, int faces, int total) {
        memo = new int[n+1][total + 1];
        for(int[] arr : memo){
            Arrays.fill(arr, -1);
        }
        int ans = recurse(n, faces, total);
        return ans % mod;
    }

    private int recurse(int n, int faces, int total){
        if(n == 0 &&  total == 0){
            return 1;
        }
        if(n == 0 || total < 0){
            return 0;
        }
        if(memo[n][total] != -1){
            return memo[n][total];
        }

        int sum =  0;
        for(int i = 1; i<= faces; i++){
            int ans = recurse(n-1, faces, total - i) % mod;
            sum = sum % mod;
            sum += ans;
        }
        memo[n][total] = sum;
        return sum;
    }
}