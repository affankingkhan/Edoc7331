//https://binarysearch.com/problems/Mutual-Followers
class Solution {
    solve(relations: Array<Array<number>>): Array<number> {

        const s1 = new Set<number>();
        const s2 = new Set<string>();

        for (const relation of relations) {
            const rel = `${relation[0]} ${relation[1]}`;
            const opp = `${relation[1]} ${relation[0]}`;

            if (s2.has(opp)) {
                s1.add(relation[0]);
                s1.add(relation[1]);
            }

            s2.add(rel);

        }
        const len = s1.size;

        const ret = new Array<number>(len)
        let i = 0;
        for (const n of s1) {
            ret[i++] = n;

        }

        return ret.sort((a, b) => a - b);

    }
}