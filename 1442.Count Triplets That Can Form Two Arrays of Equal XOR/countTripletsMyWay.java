class Solution {
    public int countTriplets(int[] arr) {
        int n = arr.length;
        int count = 0;
        
        for(int i = 0; i<n - 1; i++){
            for(int j = i+1; j<n; j++){
                int k = j;
                boolean ret = isEquals(arr,i,j,k);
                if(ret){
                    count++;
                }
                if(k < n - 1){
                    k++;
                    ret = isEquals(arr,i,j,k);
                    if(ret){
                        count++;
                    }
                }
                
                
            }
            
        }
        
        return count;
        
    }
    
    private boolean isEquals(int[] arr, int i, int j, int k){
        int a = arr[i++];
        int b = arr[j];
        
        while(i<j){
            a ^= arr[i++];
        }
        
        j++;
        
        while(j <= k){
            b ^= arr[j++];
        }
        
        return a == b;
    }
}