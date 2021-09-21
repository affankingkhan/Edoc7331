//https://binarysearch.com/problems/Social-Distancing
class Solution {
    solve(s: string, k: number): boolean {
        let n = s.length;

        const pre = new Array<number>(n);
        const suff = new Array<number>(n);


        let idx = -1;
        for (let i = 0; i < n; i++) {
            if (s[i] === 'x') {
                idx = i;
                pre[i] = 0;

            } else {
                if (idx === -1) {
                    pre[i] = Number.MAX_SAFE_INTEGER;
                } else {
                    pre[i] = i - idx;
                }
            }

        }

        idx = -1;
        for (let i = n - 1; i >= 0; i--) {
            if (s[i] === 'x') {
                idx = i;
                suff[i] = 0;

            } else {
                if (idx === -1) {
                    suff[i] = Number.MAX_SAFE_INTEGER;
                } else {
                    suff[i] = idx - i;
                }
            }

        }


        for (let i = 0; i < n; i++) {
            if (s[i] === '.') {
                let dist = Math.min(pre[i], suff[i]);
                if (dist >= k) return true;
            }
        }

        return false;

    }
}