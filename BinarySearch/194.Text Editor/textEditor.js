//https://binarysearch.com/problems/Text-Editor
class Solution {
    solve(s) {
        let ret = [];
        const n = s.length;
        let i = 0;
        while (i < n) {
            let curr = s.charAt(i);
            if (curr == "<" && s.charAt(i + 1) && s.charAt(i + 1) == "-") {
                ret.pop();
                i += 2;

            } else {
                ret.push(curr)
                i++;
            }
        }

        return ret.join("");

    }
}