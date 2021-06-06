class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int n : nums){
            set.add(n);
        }
        
        int longestCount = 0;
        
        for(int n : set){
            if(!set.contains(n-1)){
                int currCount = 0;
                int i = n;
                while(set.contains(i)){
                    i++;
                    currCount++;
                }
                longestCount = Math.max(longestCount,currCount);
            }
        }
        
        return longestCount;
        
        
    }
}