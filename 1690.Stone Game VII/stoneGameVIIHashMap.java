class Solution {
    HashMap<String,Integer> map;
    public int stoneGameVII(int[] stones) {

        map = new HashMap<>();
        
        int total = 0;
        for(int stone : stones){
            total += stone;
        }
        int i = 0;
        int j = stones.length - 1;
        return solve(stones,i,j,total);
    }
    
    
    private int solve(int[] stones, int i, int j, int total){
        if(i == j) return 0;
        if(map.containsKey("" + i + '*' + j )){
            return map.get("" + i + '*' + j );
        }
        
        int left = total - stones[i];
        
        
        int right = total - stones[j];
        
        int val = Math.max(left - solve(stones,i+1, j, left), right - solve(stones,i, j-1, right));
        map.put("" + i + '*' + j , val);
        return val;
        
        
    }
    
    
}