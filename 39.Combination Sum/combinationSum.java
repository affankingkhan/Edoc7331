class Solution {
    List<List<Integer>> ret = new ArrayList<>();
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(candidates, target, new ArrayList<>(), 0,0);
        return ret;
    }
    
    private void backtrack(int[] candidates, int target, List<Integer> list, int sum, int start){
        if(sum == target){
            ret.add(list);
        }
        
        for(int i = start; i<candidates.length; i++){
            int num = candidates[i];
            if(sum + num <= target){
                list.add(num);
                int newSum = sum + num;
                backtrack(candidates, target, new ArrayList<>(list), newSum, i);
                list.remove(list.size() -1);
            }
            
        }
    }
}