class Solution {
    public int numTeams(int[] rating) {
        
        int count = 0;
        int n = rating.length;

        for(int i=0; i<n; i++){
            // left[0] = count of elements less than rating[i] on the left of i
            // left[1] = count of elements greater than rating[i] on the left of i
            int[] left = new int[2];
            
            // right[0] = count of elements less than rating[i] on the right of i
            // right[1] = count of elements greater than rating[i] on the right of i
            int[] right = new int[2];
            
            //for each element populate the left and right arrays
            for(int j = 0;j < n; j++){
                if(j < i){
                    if(rating[j] < rating[i]){
                        left[0]++;
                    }else{
                        left[1]++;
                    }
                }
                else if(j>i){
                    if(rating[j] < rating[i]){
                        right[0]++;
                    }else{
                        right[1]++;
                    }
                    
                }
                
            }
            
            // add to the count 
            count += ((left[0] * right[1]) + (left[1] * right[0]));
            
        }
        return count;
        
    }
}