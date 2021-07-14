// https://binarysearch.com/problems/Wallstreet-Bets
import java.util.*;

class Solution {
    public int[] solve(int[] prices) {
        // stack stores the current largest elements greater than the value at index i after i
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int n = prices.length;
        int[] ret = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }
            ret[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }

        return ret;
    }
}