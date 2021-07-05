// https://binarysearch.com/problems/Find-the-Largest-Number-in-a-Rotated-List
import java.util.*;

class Solution {
    public int solve(int[] arr) {
        int n = arr.length;

        int left = 0, right = n - 1;

        while (true) {
            if (left == right) {
                return arr[left];
            }
            int m = (left + right) / 2;

            if (arr[m] > arr[m + 1])
                return arr[m];

            if (arr[left] <= arr[m]) {
                if (arr[m + 1] <= arr[right]) {
                    return arr[right];
                }
                left = m + 1;
            } else {
                right = m;
            }
        }
    }
}