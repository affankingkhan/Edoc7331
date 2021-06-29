//https://leetcode.com/problems/max-consecutive-ones-iii/
class Solution {
    int max;
    public int longestOnes(int[] nums, int k) {
        max = 0;
        
        recurse(nums,0,0,0,k);
        return max;
    }
    
    private void recurse(int[] nums, int i , int currLength, int currLongest,int k){
        if(i == nums.length){
            max = Math.max(max, currLongest);
            return;
        }
        
        if(nums[i] == 1){
            recurse(nums,i+1, currLength+1, Math.max(currLongest, currLength + 1), k);
        }else{
            if(k > 0){
                recurse(nums,i+1, currLength+1, Math.max(currLongest, currLength + 1), k -1);
            }
            recurse(nums,i+1, 0, currLongest, k);
        }
        
        return;
    }
}