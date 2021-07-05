// https://binarysearch.com/problems/Fair-Payimport java.util.*;
class Solution {
    public int solve(int[] ratings) {
        int n = ratings.length;

        int[] bank = new int[n];

        Arrays.fill(bank, 1);

        for (int i = 0; i < n - 1; i++) {
            int j = i + 1;
            if (ratings[i] < ratings[j] && bank[i] >= bank[j]) {
                bank[j] = bank[i] + 1;
            } else if (ratings[i] > ratings[j] && bank[i] <= bank[j]) {
                bank[i] = bank[j] + 1;
            }
        }

        for (int i = n - 1; i > 0; i--) {
            int j = i - 1;

            if (ratings[i] < ratings[j] && bank[i] >= bank[j]) {
                bank[j] = bank[i] + 1;
            } else if (ratings[i] > ratings[j] && bank[i] <= bank[j]) {
                bank[i] = bank[j] + 1;
            }
        }

        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += bank[i];
        }
        return sum;
    }
}