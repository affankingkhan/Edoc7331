//https://leetcode.com/problems/rectangle-overlap/
class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return isXOverlap(rec1[0], rec1[2], rec2[0], rec2[2]) && isYOverlap(rec1[1], rec1[3], rec2[1], rec2[3]);

    }
    
    private boolean isXOverlap(int l1, int r1, int l2, int r2){
        if((r1 <= l2) || (r2 <= l1)){
            return false;
        }
        return true;
    }
    
    private boolean isYOverlap(int b1, int t1, int b2, int t2){
        if((t1 <= b2) || (t2 <= b1)){
            return false;
        }
        return true;
    }

}