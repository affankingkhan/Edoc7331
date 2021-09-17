//https://binarysearch.com/problems/A-Flight-of-Stairs
class Solution {
    solve(n: number): number {

        let ret = [1, 1];

        if (n < 2) return 1;

        for (let i = 2; i <= n; i++) {
            let curr = (ret[0] + ret[1]) % 1000000007;
            ret[0] = ret[1];
            ret[1] = curr;
        }

        return ret[1];

    }
}