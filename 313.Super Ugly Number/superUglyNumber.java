class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        if(n == 1){
            return 1;
        }
        Set<Long> set = new HashSet<>();
        
        PriorityQueue<Long> heap = new PriorityQueue<>();
        
        
        heap.offer(1L);
        
        for(int i = 1; i <n; i++){
            long val = heap.poll();
            for(int j : primes){
                long ugly = val * j;
                if(!set.xacontains(ugly)){
                    set.add(ugly);
                    heap.offer(ugly);
                }
            }
        }
        
        return heap.poll().intValue();
        
    }
}