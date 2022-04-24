//https://binarysearch.com/problems/Lexicographic-Swap
class Solution {
	solve(s: string): string {
		let n = s.length;
		let i = 0;

		while (i < n) {
			const curr = s[i];
			if (curr === s[i - 1]) {
				i++;
			} else {
				let k = n - 1;
				for (let j = n - 2; j > i; j--) {
					if (s[j] < s[k]) {
						k = j;
					}
				}
				if (s[k] < curr) {
					let arr = [...s];
					this.swap(arr, i, k);
					return arr.join("");
				} else {
					i++;
				}
			}
		}

		return s;
	}

	swap(arr, first, last) {
		let temp = arr[first];
		arr[first] = arr[last];
		arr[last] = temp;
	}
}
