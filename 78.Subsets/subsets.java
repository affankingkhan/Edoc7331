class Solution {
    List<List<Integer>> ret = new ArrayList<>();
    
    public List<List<Integer>> subsets(int[] nums) {
        recurse(nums, new ArrayList<>(), 0);
        return ret;
    }
    
    private void recurse(int[] nums, List<Integer>list, int start){
        ret.add(new ArrayList<>(list));
        
        for(int i = start; i<nums.length; i++){
            list.add(nums[i]);
            recurse(nums,list,i+1);
            list.remove(list.size() -1);
            
        }
    }
}