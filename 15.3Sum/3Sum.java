class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        if(nums.length < 3){
            return new ArrayList<>();
        }
        Set<List<Integer>> ret = new HashSet<>();
        
        for(int i = 0; i<nums.length - 2; i++){
            int lead = nums[i];
            if(i == 0 || nums[i-1] != lead){
                int j = i+ 1;
                int k = nums.length - 1;
                while(j < k){
                    int sum = lead + nums[j] + nums[k];
                    if(sum == 0){
                        ret.add(Arrays.asList(lead, nums[j++],nums[k--]));
                    }
                    else if(sum < 0){
                        j++;
                    }
                    else{
                        k--;
                    }
                }
            }
        }
        return new ArrayList<>(ret);
        
    }
}