// https://binarysearch.com/problems/Robinhood
import java.util.*;

class Solution {
    public int solve(int n, int e, int o, int t) {
        int count = 0;
        double price = n;

        while (price < t) {
            if (count % 2 == 0) {
                double percent = (double) e / 100;
                percent += 1;
                price *= percent;

            } else {
                double percent = (double) o / 100;
                percent += 1;
                price *= percent;
            }
            count++;
        }
        return count;
    }
}