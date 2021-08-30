//https://leetcode.com/problems/maximum-units-on-a-truck/
class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {  
        Arrays.sort(boxTypes, (a,b) -> b[1] - a[1]);
        int n = boxTypes.length;
        
        int maxUnit = 0;
        int i = 0;
        
        while(truckSize > 0 && i < n){
            int[] curr = boxTypes[i];
            int numBox = Math.min(truckSize, curr[0]);
            maxUnit += (numBox * curr[1]);
            truckSize -= numBox;
            i++;
        }
        return maxUnit;
    }
}