//https://binarysearch.com/problems/String-Addition
class Solution {
    solve(a, b) {

        let l1 = a.length;
        let l2 = b.length;

        let i = l1 - 1;
        let j = l2 - 1;

        let carry = 0;
        const ret = [];

        while (i >= 0 || j >= 0) {
            let val = carry;
            if (i >= 0) {
                val += parseInt(a[i--]);
            }
            if (j >= 0) {
                val += parseInt(b[j--]);
            }

            if (val >= 10) {
                val %= 10;
                carry = 1;
            } else {
                carry = 0;
            }

            ret.unshift(val.toString());
        }

        if (carry) {
            ret.unshift("1");

        }

        return ret.join("")

    }
}