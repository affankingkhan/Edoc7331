//https://binarysearch.com/problems/Roomba
class Solution {
    solve(moves: Array<string>, x: number, y: number): boolean {
        //x
        let i = 0;
        //y
        let j = 0;

        for (let move of moves) {
            if (move === "NORTH") {
                j++;

            }
            else if (move === "SOUTH") {
                j--;
            }

            else if (move === "EAST") {
                i++;
            }

            else if (move === "WEST") {
                i--;
            }

        }

        return i === x && j === y;

    }
}