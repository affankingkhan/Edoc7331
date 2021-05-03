class Solution {
    public int maximumScore(int a, int b, int c) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((t,y) -> y-t);
        
        maxHeap.offer(a);
        maxHeap.offer(b);
        maxHeap.offer(c);
        
        int score = 0;
        
        while(maxHeap.size() > 1){
            int x = maxHeap.poll();
            int y = maxHeap.poll();
            score++;
            x--;
            y--;
            if(x > 0){
                maxHeap.offer(x);
            }
            if(y>0){
                maxHeap.offer(y);
            }
        }
        
        return score;
        
        
    }
}