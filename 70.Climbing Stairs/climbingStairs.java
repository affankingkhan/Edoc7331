class Solution {
    public int climbStairs(int n) {
        
        if(n == 1 || n == 0){
            return 1;
        }
        int[] vals = new int[2];
        vals[0] = 1;
        vals[1] = 1;
        
        for(int i = 2; i<=n;i++){
            int sum = vals[0] + vals[1];
            vals[0] = vals[1];
            vals[1] = sum;
        }
        return vals[1];
    }
}