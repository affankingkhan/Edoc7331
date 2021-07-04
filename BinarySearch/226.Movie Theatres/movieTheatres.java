// https://binarysearch.com/problems/Movie-Theatres
import java.util.*;

class Solution {
    public int solve(int[][] intervals) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        // store the interval in the min heap by start time
        for (int[] interval : intervals) {
            q.offer(interval);
        }

        // this heap stores the latest endtime of all the theaters
        PriorityQueue<Integer> q2 = new PriorityQueue<>();

        while (!q.isEmpty()) {
            // get the interval with the earliest start time and see if it
            int[] curr = q.poll();
            // if the start time is earlier than the earliest end time, we add a new theater
            if (q2.isEmpty() || q2.peek() > curr[0]) {
                q2.offer(curr[1]);

            }

            // if the start time is after or equal to the earliest end time, we update that time
            else {
                q2.poll();
                q2.offer(curr[1]);
            }
        }

        return q2.size();
    }
}