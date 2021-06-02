class Solution {
    public void nextPermutation(int[] nums) {
        
        // find the first i from the end of the array where nums[i] < nums[i+1]
        int i = nums.length - 2; 
        while(i >= 0){
            if(nums[i] < nums[i+1]){
                break;
            }
            i--;
        }
        
        int j = nums.length - 1;
        
        // if we found an i, then find first index j where nums[j] > nums[i]
        //if we didn't find an i, i == -1
        if(i >= 0){
            while(nums[j] <= nums[i]){
                j--;
            }
            swap(nums,i,j);
        }
        
        
        //reverse the characters of nums after the index i
        
        i++;
        j = nums.length -1;
        
        while(i < j){
            swap(nums, i, j);
            i++;
            j--;
        }
        return;
        
    }
    
    // custom swap function
    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp; 
    }
}