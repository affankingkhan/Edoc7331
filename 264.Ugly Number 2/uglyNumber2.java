class Solution {
    public int nthUglyNumber(int n) {
        int i = 1;
        if(n == 1){
            return i;
        }
        
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        int[] div = {2,3,5};
        
        minHeap.offer(1L);
        
        for(int j  = 1; j< n; j++){
            long val = minHeap.poll();
            for(int k : div){
                long ugly  = val * k;
                if(! minHeap.contains(ugly)){
                    minHeap.offer(ugly);
                }
            }
        }
        
        return minHeap.poll().intValue();
    }
}