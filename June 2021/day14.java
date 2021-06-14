class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> b[1] - a[1]);
        
        for(int[] boxType: boxTypes){
            maxHeap.offer(boxType);
        }
        
        int maxUnit = 0;
        
        while(truckSize > 0 && !maxHeap.isEmpty()){
            int[] boxType = maxHeap.poll();
            int numBox = Math.min(truckSize, boxType[0]);
            maxUnit += (numBox * boxType[1]);
            truckSize -= numBox;
            
        }
        
        return maxUnit;
        
    }
}