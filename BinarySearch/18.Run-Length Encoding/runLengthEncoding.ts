//https://binarysearch.com/problems/Run-Length-Encoding
class Solution {
    solve(s: string): string {

        let curr = "";
        let count = 0;
        let ret = "";

        for (let i = 0; i < s.length; i++) {
            let ch = s[i];
            if (ch != curr && curr != "") {
                ret += count + curr
                curr = ch;
                count = 1;

            } else {
                if (curr === "") {
                    curr = ch;
                }
                count++;

            }

        }

        if (count) {
            ret += count + curr;
        }

        return ret;

    }
}