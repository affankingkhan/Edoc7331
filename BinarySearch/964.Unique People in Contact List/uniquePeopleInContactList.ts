//https://binarysearch.com/problems/Unique-People-in-Contact-List
class Solution {
    solve(contacts: Array<Array<string>>): number {

        const s = new Set();
        let count = 0;
        for (const contactArr of contacts) {
            let found = false;
            for (const contact of contactArr) {
                if (s.has(contact)) {
                    found = true;
                } else {
                    s.add(contact);
                }
            }
            if (!found) count++;
        }

        return count;

    }
}