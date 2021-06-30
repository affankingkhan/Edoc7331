//https://leetcode.com/problems/rectangle-area/
class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        
        int aArea = (ax2 - ax1) * (ay2 - ay1);
        int bArea = (bx2 - bx1) * (by2 - by1);
        
        int overlap = computeOverlap(ax1, ay1, ax2, ay2, bx1, by1, bx2, by2);
        
        return (aArea - overlap) + (bArea);
        
    }
    
    private int computeOverlap(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2){
        if((ax2 <= bx1 && ax2 < bx2) || (ax1 >= bx2 && ax1 > bx1)) return 0;
        
        int right = Math.min(ax2,bx2);
        int left = Math.max(ax1,bx1);
        
        int xLength = right - left;
        
        if((ay2 <= by1 && ay2 < by2) || (ay1 >= by2 && ay1 > by1)) return 0;
        
        int top = Math.min(ay2,by2);
        int bottom = Math.max(ay1,by1);
        
        int yLength = top - bottom;
        
        return xLength * yLength;
         
    }
}