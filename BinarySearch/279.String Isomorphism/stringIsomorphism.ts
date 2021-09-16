//https://binarysearch.com/problems/String-Isomorphism
class Solution {
    solve(s: string, t: string): boolean {
        if (s.length != t.length) return false;

        const mapS = {};
        const mapT = {};


        for (let i = 0; i < s.length; i++) {
            let cS = s[i];
            let cT = t[i];

            if (!mapS[cS] && !mapT[cT]) {
                mapS[cS] = cT;
                mapT[cT] = cS;
            } else {
                if (mapS[cS] != cT || mapT[cT] != cS) return false;
            }

        }

        return true;

    }
}