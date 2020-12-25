class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int a : A){
            for(int b: B){
                map.put(a+b, map.getOrDefault(a+b, 0) + 1);
            }
        }
        
        int count = 0;
        
        for(int c : C){
            for(int d: D){
                count += map.getOrDefault(-(c+d),0);
            }
        }
        
        return count;
        
    }
}