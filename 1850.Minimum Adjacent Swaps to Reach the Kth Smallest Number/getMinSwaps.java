class Solution {
    public int getMinSwaps(String num, int k) {
        char[] actual = num.toCharArray();
        char[] temp = num.toCharArray();
        while(k > 0){
            fetchNextPerm(temp);
            k--;
        }
        
        int count = 0;
        
        for(int i = 0; i< actual.length; i++){
            if(actual[i] != temp[i]){
                int j = i+1;
                while(j<actual.length && actual[j] != temp[i]){
                    j++;
                }
                while(i < j){
                    swap(actual,j,j-1);
                    j--;
                    count++;
                }
                
            }
        }
        
        return count;
    }
    
    private void fetchNextPerm(char[] nums){
        int i = nums.length - 2; 
        while(i >= 0){
            if(nums[i] < nums[i+1]){
                break;
            }
            i--;
        }
        
        int j = nums.length - 1;
        
        while(nums[j] <= nums[i]){
            j--;
        }
        
        swap(nums,i,j);
        
        i++;
        j = nums.length -1;
        
        while(i < j){
            swap(nums, i, j);
            i++;
            j--;
        }
        return;
           
    }
    
    private void swap(char[] arr, int i, int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp; 
    }
}