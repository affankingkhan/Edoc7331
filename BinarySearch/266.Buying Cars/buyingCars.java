// https://binarysearch.com/problems/Buying-Cars
import java.util.*;

class Solution {
    public int solve(int[] prices, int k) {
        Arrays.sort(prices);

        int c = 0;

        for (int price : prices) {
            if (k >= price) {
                c++;
                k -= price;
            } else {
                break;
            }
        }

        return c;
    }
}