class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int[] ret = new int[2]; 
        
        for(int i =0; i< nums.length; i++){
            int value = target - nums[i];
            if(map.containsKey(value)){
                ret[0] = map.get(value);
                ret[1] = i;
                break;
            }else{
                map.put(nums[i], i);
            }
        }
        return ret;
        
    }
}