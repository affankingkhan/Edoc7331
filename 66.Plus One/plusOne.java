class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        int j = len -1;
        
        if(digits[len -1] == 9){
            if(areAllNines(digits)){
                int[] ret = new int[digits.length + 1];
                ret[0] = 1;
                return ret;
            }else{
                while(j>=0){
                    if(digits[j] == 9){
                        digits[j] = 0;
                    }else{
                        digits[j]++;
                        return digits;
                    }
                    j--;
                }
            }
            
        }else{
            digits[len -1]++;
        }
        return digits;
    }
    
    private boolean areAllNines(int[] digits){
        for(int num : digits){
            if(num != 9){
                return false;
            }
        }
        return true;
    }
}