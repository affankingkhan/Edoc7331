class Solution {
    public int findPairs(int[] nums, int k) {
        int ans=0;
        if(k==0){
            Map<Integer, Integer> map = new HashMap<>();
            for(int n: nums){
                map.put(n, map.getOrDefault(n,0)+1);
                if(map.get(n)==2)ans++;
            }
            return ans;
        }
        
        Set<Integer> set = new HashSet<>();
        
        for(int n: nums){
            if(!set.contains(n)){
                if(set.contains(n-k))ans++;
                if(set.contains(n+k))ans++;
                set.add(n);
            }
        }
        
        return ans;
    }
}