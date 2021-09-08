//https://binarysearch.com/problems/Clock-Angle
class Solution {
    solve(hour: number, minutes: number): number {
        // get total number of minutes since 0:00
        let totalMins = (60 * hour) + minutes;
        // minute hand moves 6 degrees per minute
        let mDegree = 6 * totalMins;
        // hour hand moves 0.5 degrees per minute
        let hDegree = 0.5 * totalMins
        // mod both by 360
        mDegree %= 360;
        hDegree %= 360;

        // get the absolute value difference
        let difference = Math.max(mDegree, hDegree) - Math.min(mDegree, hDegree);
        // if difference is greater than 180 than difference is the difference between 360 and difference
        if (difference > 180) {
            difference = 360 - difference;
        }

        // return floor of difference
        return Math.floor(difference);

    }
}