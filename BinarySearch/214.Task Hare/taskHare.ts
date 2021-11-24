//https://binarysearch.com/problems/Task-Hare
class Solution {
    solve(tasks: Array<number>, people: Array<number>): number {
        tasks.sort((a, b) => a - b);
        people.sort((a, b) => a - b);

        let i = 0;
        for (let j = 0; j < people.length; j++) {
            if (i >= tasks.length) break;
            if (tasks[i] <= people[j]) {
                i++;
            }
        }

        return i;
    }
}