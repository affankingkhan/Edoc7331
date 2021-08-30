// https://binarysearch.com/problems/Palindromic-Integer
import java.util.*;

class Solution {
    public boolean solve(int num) {
        List<Integer> list = new ArrayList<>();

        while (num > 0) {
            int dig = num % 10;
            num /= 10;
            list.add(dig);
        }

        int n = list.size();

        int i = 0;
        int j = n - 1;

        while (i < j) {
            if (list.get(i++) != list.get(j--))
                return false;
        }
        return true;
    }
}