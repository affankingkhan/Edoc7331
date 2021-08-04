// https://binarysearch.com/problems/Rectangular-Overlap
import java.util.*;

class Solution {
    public boolean solve(int[] rect0, int[] rect1) {
        boolean isXOverlap = false;
        boolean isYOverlap = false;

        if ((rect1[0] < rect0[2] && rect1[2] > rect0[0])
            || (rect0[0] < rect1[2] && rect0[2] > rect1[0]))
            isXOverlap = true;

        if ((rect1[1] < rect0[3] && rect1[3] > rect0[1])
            || (rect0[1] < rect1[3] && rect0[3] > rect1[1]))
            isYOverlap = true;

        return isXOverlap && isYOverlap;
    }
}