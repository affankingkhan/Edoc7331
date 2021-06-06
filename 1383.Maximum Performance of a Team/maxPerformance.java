class Solution {
    class Engineer {
        int speed;
        int efficiency;
        
        Engineer(int s, int e){
            this.speed = s;
            this.efficiency = e;
        }
    }
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        
        Engineer[] engineers = new Engineer[n];
        
        for(int i = 0 ; i<n; i++){
            engineers[i] = new Engineer(speed[i], efficiency[i]);
        }
        
        Arrays.sort(engineers, (a,b) -> b.efficiency - a.efficiency);
        
        long result = 0;
        long speedSum = 0;
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for(Engineer eng : engineers){
            speedSum += eng.speed;
            minHeap.offer(eng.speed);
        
            if(minHeap.size() > k){
                speedSum -= minHeap.poll();
            }
            result = Math.max(result, speedSum * eng.efficiency);
            
        }
        return (int) (result % ((long)1e9 + 7));
        
        
    }
}