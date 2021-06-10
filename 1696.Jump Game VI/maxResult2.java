class Solution {
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        int score = nums[0];
        
        // maxheap of arrays
        // first index is the value of nums
        // second index is the index of the value
        // heap position is based of the value
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[0] - a[0]);
        
        pq.offer(new int[]{nums[0], 0});
        
        for(int i = 1; i< n; i++){
            
            // this while loops removes all the element in the pq that are out of bound
            // ie. their index is more than k less than the current index
            // this leaves the top element that is within range to jump from to the current index
            while(i - k > pq.peek()[1] ){
                pq.poll();
            }
            
            // get the current max element from the pq and set the new score
            int[] maxElement = pq.peek();
            score = nums[i] + maxElement[0];
            pq.offer(new int[]{score, i});
            
        }
        
        return score;
        
    }
}