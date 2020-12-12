class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0;
        int j = 1;
        while(j < nums.length){
            if(nums[i] != 0){
                i++;
                j++;
            }
            else{
                if(nums[j] != 0){
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }else{
                    j++;
                }
            }
        }
        return;
        
    }
}
