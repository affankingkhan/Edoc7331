//https://binarysearch.com/problems/Palindrome-Count
// abc     abc         ab

// aaa     aaaa        aaaa
// bbb     bbbb        bbbb
// ccc     cccc

// aba     abba        abba
// aca     acca        baab
// bab     baab
// bcb     bccb
// cac     caac
// cbc     cbbc

class Solution {
	solve(s: string, k: number): number {
		const f = [...s].filter((x, i, a) => a.indexOf(x) == i);
		let len = f.length;

		let n = Math.ceil(k / 2);

		return len ** n;
	}
}
