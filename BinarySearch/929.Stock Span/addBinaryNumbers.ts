//https://binarysearch.com/problems/Add-Binary-Numbers
class Solution {
    solve(a: string, b: string): string {
        let i = a.length - 1;
        let j = b.length - 1;
        let ret = [];

        let carry = 0;
        while (i >= 0 || j >= 0) {
            let val = carry;

            if (i >= 0) {
                val += parseInt(a[i--]);
            }
            if (j >= 0) {
                val += parseInt(b[j--]);
            }

            if (val > 1) {
                carry = 1;
                val %= 2;
            }
            else {
                carry = 0
            }
            ret.unshift(val.toString());
        }
        if (carry) {
            ret.unshift(1);
        }

        return ret.join("");

    }
}