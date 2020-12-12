class Solution {
    //global variable where we will append the different permutations
    List<List<Integer>> ret = new ArrayList<>();
    
    public List<List<Integer>> permute(int[] nums) {
        // create the choices, using list so its easier to add and remove choices
        List<Integer> choices = new ArrayList<>();
        for(int n : nums){
            choices.add(n);
        }
        //we need to pass only the length
        int len = nums.length;
        
        //call recursive function here.
        backtrack(len,choices,new ArrayList<>());
        return ret;
    }
    
    private void backtrack(int len, List<Integer> choices, List<Integer> list){
        if(list.size() == len){
            ret.add(list);
            return;
        }
        
        
        for(int i = 0; i< choices.size();i++){
            //make a choice
            list.add(choices.get(i));
            //create a new list with without the choice you just made
            List<Integer> reduced = new ArrayList<>(choices);
            reduced.remove(i);
            // back track with the sub choices
            backtrack(len,reduced,new ArrayList<>(list));
            
            //remove the choice so in the next iteration we can make a different choice
            list.remove(list.size() - 1);
            
        }
    }
}