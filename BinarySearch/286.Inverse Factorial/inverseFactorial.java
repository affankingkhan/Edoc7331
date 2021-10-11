// https://binarysearch.com/problems/Inverse-Factorial
import java.util.*;

class Solution {
    public int solve(int a) {
        int fac = 1;
        int i = 0;

        while (fac < a) {
            i++;
            fac *= i;
        }
        return fac == a ? i : -1;
    }
}