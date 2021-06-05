class Solution {
    public int findTheWinner(int n, int k) {
        
        ArrayDeque<Integer> q = new ArrayDeque<>();
        
        for(int i=1 ; i<= n; i++){
            q.offer(i);
        }
        int count = 1;
        while(q.size() > 1){
            int curr = q.poll();
            if(count != k){
                q.offer(curr);
                
            }
            
            count++;
            if(count > k){
                count = 1;
            }
            
            
        }
        
        return q.poll();
        
        
        
    }
}