//https://binarysearch.com/problems/Generate-Anagram-Substrings
class Solution {
    solve(s: string): Array<string> {

        const n = s.length;
        const ret = [];
        const map = {};
        for (let i = 0; i < n; i++) {
            for (let j = i + 1; j <= n; j++) {
                let sub = s.substring(i, j);
                const key = sub.split("").sort().join("");
                if (map[key]) {
                    map[key].push(i);
                } else {
                    map[key] = [i];
                }


            }
        }

        for (let key in map) {
            const arr = map[key];
            if (arr.length > 1) {
                let n = key.length;
                for (let num of arr) {
                    let curr = s.substring(num, num + n);
                    ret.push(curr);

                }
            }

        }

        ret.sort();
        return ret;
    }
}