class Solution {
    HashSet<Integer> hSet;
    HashSet<Integer> vSet;
    int localCount = 0;
    
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        
        int largestVerticalGap = 0;
        
        int largestHorizontalGap = 0;
    
        int behind = 0;
        
        
        for(int i : verticalCuts){
            largestVerticalGap = Math.max(largestVerticalGap, i - behind);
            behind = i;
        }
        
        largestVerticalGap = Math.max(largestVerticalGap, w - behind);
        
        
        behind = 0;
        
        for(int j : horizontalCuts){
            largestHorizontalGap = Math.max(largestHorizontalGap, j - behind);
            behind = j;
        }
        
        largestHorizontalGap = Math.max(largestHorizontalGap, h - behind);
        
        return (int)((largestVerticalGap * 1L * largestHorizontalGap) % 1000000007);

    }

}