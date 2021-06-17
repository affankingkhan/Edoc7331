class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        //start is the 
        int start = -1, end = -1, count = 0;
        for(int i=0; i<nums.length; i++){
            
            // if num[i] < left, we just add 1 more for each of the previous starting at end and going down to start
            if(nums[i] < left) {
                count += (end - start);
            }

            //if greater than right, we update both start and end pointers since we can't include this in our sub array
            else if(nums[i] > right){
                start = i;
                end = i;
            }
            
            // if left <= num[i] <= right , we increment end and do the same as if were less than left
            else{
                end = i;
                count += end - start;
            }
        }
        return count;
    }
}