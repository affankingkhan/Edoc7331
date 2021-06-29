//https://leetcode.com/problems/max-consecutive-ones-iii/submissions/
class Solution {
    
    public int longestOnes(int[] nums, int k) {
        int max = 0;
        int n = nums.length;
        
        int i = 0;
        int currZeroCount = 0;
        
        // store the indexes of the previous zeros
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int j = 0; j< nums.length;j++){
            if(nums[j] == 1){
                max = Math.max(max, j - i + 1);
            }
            else{
                if(currZeroCount  == k){
                    if(k == 0){
                        i = j+1;
                    }
                    else{
                        // fetch the index of the first 0 in the window and add 1
                        i = pq.poll() + 1;
                        max = Math.max(max, j - i + 1);
                        pq.offer(j);
                    }
                    
                    
                }else{
                   max = Math.max(max, j - i + 1);
                    currZeroCount++;
                    pq.offer(j);
                }
            }
        }
        
        return max;
    }
}