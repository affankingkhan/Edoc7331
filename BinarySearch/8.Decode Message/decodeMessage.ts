//https://binarysearch.com/problems/Decode-Message
class Solution {
    solve(message: string): number {
        const n = message.length
        const dp = new Array<number>(n + 1);
        dp[n] = 1;
        dp[n - 1] = message[n - 1] === '0' ? 0 : 1;

        for (let i = n - 2; i >= 0; i--) {
            dp[i] = 0;
            if (message[i] === "0") {
                continue;
            }
            dp[i] = dp[i + 1];
            let a = parseInt(message[i] + message[i + 1]);
            if (a <= 26) {
                dp[i] += dp[i + 2];
            }

        }
        return dp[0];
    }
}