//https://binarysearch.com/problems/Swap-Characters-to-Equalize-Strings
class Solution {
    solve(s: string, t: string): boolean {
        const n = s.length;
        const map = {};

        let evenCount = 0;
        for (let i = 0; i < n; i++) {
            if(map[s[i]]){
                map[s[i]]++;
                if(map[s[i]] % 2 == 0) evenCount++;
                else{
                    evenCount--;
                }
            }else{
                map[s[i]] = 1;
            }

            if(map[t[i]]){
                map[t[i]]++;
                if(map[t[i]] % 2 == 0) evenCount++;
                else{
                    evenCount--;
                }
            }else{
                map[t[i]] = 1;
            }
        }

        return evenCount === Object.keys(map).length;

    }
}