//https://binarysearch.com/problems/First-Fit-Room
class Solution {
    solve(rooms: Array<number>, target: number): number {

        for (let room of rooms) {
            if (room >= target) return room;
        }
        return -1;

    }
}