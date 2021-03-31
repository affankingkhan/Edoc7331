class Solution {
    public int lastStoneWeight(int[] stones) {
        if(stones.length == 1) return stones[0];
        if(stones.length == 0) return 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b-a);
        
        for(int s : stones){
            maxHeap.offer(s);
        }
        while(maxHeap.size() > 1){
            int y = maxHeap.poll();
            int x = maxHeap.poll();
            if(x != y){
                maxHeap.offer(y-x);
            }
        }
        return (maxHeap.peek() != null) ? maxHeap.poll() : 0;
    }
}