//https://binarysearch.com/problems/A-Unique-String
class Solution {
    solve(s: string): boolean {
        const hashtable = new Set();

        for (let i = 0; i < s.length; i++) {
            let char = s[i];
            if (hashtable.has(char)) return false;
            hashtable.add(char);
        }
        return true;
    }
}