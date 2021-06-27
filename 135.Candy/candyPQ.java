//https://leetcode.com/problems/candy/submissions/
class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        
        for(int i = 0; i< n; i++){
            pq.offer(new int[]{ratings[i], i});
        }
        
        int[] ans = new int[n];
        
        int counter = 0;
        
        while(!pq.isEmpty()){
            int[] temp = pq.poll();
            int ind = temp[1];
            int curr = 0;
            if(ind - 1 >= 0 && ratings[ind] != ratings[ind - 1]) curr = Math.max(ans[ind - 1], curr);
            if(ind + 1 < n && ratings[ind] != ratings[ind + 1]) curr = Math.max(ans[ind + 1], curr);
            ans[ind] = curr + 1;
            counter += ans[ind];
            
        }
        return counter;
        
        
    }
}