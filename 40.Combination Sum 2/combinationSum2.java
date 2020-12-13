class Solution {
    List<List<Integer>> ret = new ArrayList<>();
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        recurse(candidates, target, new ArrayList<>(), 0);
        return ret;
        
    }
    
    private void recurse(int[] candidates, int target, List<Integer> curr, int start){
        if(target < 0){
            return;
        }
        else if(target == 0){
            ret.add(new ArrayList<>(curr));
        }
        
        for(int i = start; i<candidates.length; i++){
            //dont need to do dfs for tw
            if(i != start && candidates[i] == candidates[i-1]){
                continue;
            }
            curr.add(candidates[i]);
            recurse(candidates, target - candidates[i], curr, i+1);
            curr.remove(curr.size() - 1);
        }
        
    }
    
}