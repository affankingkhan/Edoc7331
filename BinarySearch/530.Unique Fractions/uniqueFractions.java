// https://binarysearch.com/problems/Unique-Fractions
import java.util.*;

class Solution {
    public int[][] solve(int[][] fractions) {
        List<int[]> list = new ArrayList<>();
        HashSet<Double> seen = new HashSet<>();

        for (int[] frac : fractions) {
            int num = frac[0];
            int denom = frac[1];
            double q = (double) num / (double) denom;
            if (seen.contains(q))
                continue;
            seen.add(q);

            boolean isNegative = false;
            if (denom < 0 && num > 0 || denom > 0 && num < 0) {
                isNegative = true;
                num = Math.abs(num);
                denom = Math.abs(denom);
            }

            int gcd = gcd(num, denom);
            if (gcd != 1) {
                num /= gcd;
                denom /= gcd;
            }
            if (isNegative) {
                num *= -1;
            }

            list.add(new int[] {num, denom});
        }

        Collections.sort(list,
            (a, b) -> Double.compare((double) a[0] / (double) a[1], (double) b[0] / (double) b[1]));

        int[][] array = new int[list.size()][2];
        list.toArray(array);
        return array;
    }

    private int gcd(int a, int b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }
}