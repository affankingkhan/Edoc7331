// https://binarysearch.com/problems/Task-Run
import java.util.*;

class Solution {
    public int solve(int[] tasks, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int idx = 0;
        int n = tasks.length;
        int time = 0;

        while (idx < n) {
            // System.out.println(time);
            int job = tasks[idx];
            if (map.containsKey(job)) {
                int lastTime = map.get(job);
                int diff = time - lastTime;
                if (diff < k) {
                    // wait
                    time += (k - diff);
                } else {
                    // no wait
                    time++;
                    map.put(job, time);
                    idx++;
                }

            } else {
                time++;
                map.put(job, time);
                idx++;
            }
        }

        return time;
    }
}