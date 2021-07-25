// https://binarysearch.com/problems/FizzBuzz
import java.util.*;

class Solution {
    public String[] solve(int n) {
        String[] ret = new String[n];
        for (int i = 1; i <= n; i++) {
            boolean isMultiple5 = false;
            boolean isMultiple3 = false;
            if (i % 5 == 0)
                isMultiple5 = true;
            if (i % 3 == 0)
                isMultiple3 = true;
            if (!isMultiple5 && !isMultiple3) {
                ret[i - 1] = String.valueOf(i);
            } else {
                String r = "";
                if (isMultiple3)
                    r += "Fizz";
                if (isMultiple5)
                    r += "Buzz";
                ret[i - 1] = r;
            }
        }
        return ret;
    }
}