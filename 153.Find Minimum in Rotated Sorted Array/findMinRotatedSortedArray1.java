//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/submissions/
class Solution {
    
    public int findMin(int[] nums) {  
        int n = nums.length;
        int left = 0, right = n - 1;
        
        // if left is less than or equal to right, then there is no rotation
        if(nums[left] <= nums[right]) return nums[left];
        
        while(right >= left){
            int m = (left+right) / 2;
            
            if(nums[m] > nums[m+1]) return nums[m+1];
            if(nums[m] < nums[m - 1]) return nums[m];
            
            if(nums[m] > nums[0]){
                left = m +1;
            }else{
                right = m-1;
            }
            
            
        }
        return 0;
    }
    
    
}