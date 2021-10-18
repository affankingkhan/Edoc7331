// https://binarysearch.com/problems/Maximize-Social-Distancing
import java.util.*;

class Solution {
    public int solve(int[] seats) {
        int n = seats.length;
        int closest = 0;

        int[] left = new int[n];
        int[] right = new int[n];

        int lastSeen1 = -1;

        for (int i = 0; i < n; i++) {
            if (seats[i] == 1) {
                lastSeen1 = i;
            } else {
                if (lastSeen1 != -1) {
                    left[i] = i - lastSeen1;
                } else {
                    left[i] = Integer.MAX_VALUE;
                }
            }
        }

        lastSeen1 = -1;

        for (int i = n - 1; i >= 0; i--) {
            if (seats[i] == 1) {
                lastSeen1 = i;
            } else {
                if (lastSeen1 != -1) {
                    right[i] = lastSeen1 - i;
                } else {
                    right[i] = Integer.MAX_VALUE;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (seats[i] == 0) {
                closest = Math.max(closest, Math.min(left[i], right[i]));
            }
        }

        return closest;
    }
}