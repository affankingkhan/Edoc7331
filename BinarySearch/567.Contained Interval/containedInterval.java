// https://binarysearch.com/problems/Contained-Interval
import java.util.*;

class Solution {
    public boolean solve(int[][] intervals) {
        int n = intervals.length;
        if (n < 2)
            return false;
        Arrays.sort(intervals, (a, b) -> compare(a, b));
        int[] prev = intervals[0];

        for (int i = 1; i < n; i++) {
            int[] current = intervals[i];
            if (current[0] <= prev[1] && current[1] <= prev[1])
                return true;
            prev = current;
        }

        return false;
    }

    private int compare(int[] a, int[] b) {
        if (a[0] < b[0])
            return -1;
        if (a[0] > b[0])
            return 1;
        else {
            if (a[1] > b[1])
                return -1;
            if (a[1] < b[1])
                return 1;
            return 0;
        }
    }
}