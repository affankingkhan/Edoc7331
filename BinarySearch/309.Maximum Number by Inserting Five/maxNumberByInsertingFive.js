//https://binarysearch.com/problems/Maximum-Number-by-Inserting-Five
class Solution {
    solve(n) {
        if (n >= 0) {
            let str = n.toString()
            for (let i = 0; i < str.length; i++) {
                if (str[i] < '5') {
                    return parseInt(`${str.substring(0,i)}5${str.substring(i)}`)
                }
            }
            return parseInt(`${str}5`)
        }

        n = Math.abs(n)
        let str = n.toString()
        for (let i = 0; i < str.length; i++) {
            if (str[i] > '5') {
                return parseInt(`-${str.substring(0,i)}5${str.substring(i)}`)
            }
        }
        return parseInt(`-${str}5`)

    }
}