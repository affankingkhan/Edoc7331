//https://binarysearch.com/problems/Validate-Delivery-Orders
class Solution {
    solve(orders: Array<string>): boolean {

        const map = {};

        for (let order of orders) {
            let letter = order[0];
            let num = order.substring(1);
            if (map[num]) {
                if (map[num] === 'D' || letter === 'P') return false;
                map[num] = 'D';

            } else {
                if (letter === 'P') {
                    map[num] = 'P';
                } else {
                    return false;
                }
            }
        }

        for (let num in map) {
            if (map[num] !== 'D') return false;
        }
        return true;
    }
}