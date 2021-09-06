//https://binarysearch.com/problems/Rotation-Groups
class Solution {
	solve(words: Array<string>): number {
		const hSet = new Set();
		for (let str of words) {
			const s = str + str;
			let found = false;
			for (let i = 0; i < str.length; i++) {
				const sub = s.substring(i, i + str.length);
				if (hSet.has(sub)) {
					found = true;
					break;
				}
			}
			if (!found) {
				hSet.add(str);
			}
		}

		return hSet.size;
	}
}
