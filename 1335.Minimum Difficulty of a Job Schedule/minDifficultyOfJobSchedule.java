//https://leetcode.com/problems/minimum-difficulty-of-a-job-schedule/submissions/
class Solution {
    HashMap<String,Integer> memo;
    
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if(n < d)  return -1;
        memo = new HashMap<>();
        return recurse(jobDifficulty,0,d, n);
        
    }
    
    private int recurse(int[] jd, int i , int d, int n){
        String key = i + "-" + d;
        if(memo.containsKey(key)) return memo.get(key);
        if(d == 1){
            int max = 0;
            for(int j = i; j<n;j++){
                max=Math.max(max,jd[j]);
            }
            memo.put(key,max);
            return max;
        }
        
        int maxSoFar = 0;
        int ans = Integer.MAX_VALUE;
        
        for(int j = i; j <= n-d; j++){
            maxSoFar = Math.max(maxSoFar, jd[j]);
            ans = Math.min(ans, maxSoFar + recurse(jd,j+1, d-1, n));
        }
        memo.put(key,ans);
        
        return ans; 
    }
}