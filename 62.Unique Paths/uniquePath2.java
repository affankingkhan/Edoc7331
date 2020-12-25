class Solution {
    
    public int uniquePaths(int m, int n) {
        int N = m + n -2;
        int K = m -1;
        
        return NchooseK(N,K);
        
    }
    
    private int NchooseK(int N, int K){
        long numerator = 1;
        for(int i = N-K+1; i<=N; i++){
            numerator *= i;
        }
        long denom = factorial(K);
        return (int)(numerator/denom);
        
        
    }
    
    private long factorial(int k){
        long ret  = 1;
        
        for(int i=1; i<=k;i++){
            ret *= i;
        }
        return ret;
    }
    
    
}