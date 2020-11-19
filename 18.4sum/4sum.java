class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        
        Set<List<Integer>> set = new HashSet<>();
        
        for(int i = 0; i<nums.length -3; i++){
            int first = nums[i];
            if(i == 0 || nums[i-1] != first){
                for(int j = i + 1; j<nums.length - 2; j++){
                    int second = nums[j];
                    int k = j + 1;
                    int z = nums.length - 1;
                    while(k < z){
                        int third = nums[k];
                        int fourth = nums[z];
                        int sum = first + second + third + fourth;
                        if(sum == target){
                            set.add(Arrays.asList(first,second,third,fourth));
                            k++;
                            z--;
                        }
                        else if (sum < target){
                            k++;
                        }else{
                            z--;
                        }

                    }

                }
            }
            
        }
        
        return new ArrayList<>(set);
    }
}