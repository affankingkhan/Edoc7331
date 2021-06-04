class Solution {
    public int numTeams(int[] rating) {
        
        int count = 0;
        int n = rating.length;
        
        for(int i = 0; i<n-2; i++){
            for(int j = i +1; j<n-1; j++){
                if(rating[j] > rating[i]){
                    for(int k = j + 1; k<n; k++){
                        if(rating[k] > rating[j]){
                            count++;
                        }
                    }
                }
            }
        }
        
        for(int i = n-1; i>=2; i--){
            for(int j = i -1; j>=1; j--){
                if(rating[j] > rating[i]){
                    for(int k = j -1 ; k>=0; k--){
                        if(rating[k] > rating[j]){
                            count++;
                        }
                    }
                }
            }
        }
        
        return count;
        
    }
}