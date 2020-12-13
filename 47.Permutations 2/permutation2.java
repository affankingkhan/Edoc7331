class Solution {
    List<List<Integer>> ret = new ArrayList<>();
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int n: nums){
            map.put(n,map.getOrDefault(n,0) + 1);
        }
        recurse(map, new ArrayList<>(), nums.length);
        
        return ret;
        
        
    }
    
    private void recurse(HashMap<Integer,Integer> map,List<Integer> curr, int N){
        if(N == curr.size()){
            ret.add(new ArrayList<>(curr));
            return;
        }
        
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            int num = entry.getKey();
            int count = entry.getValue();
            
            if(count == 0){
                continue;
            }
            curr.add(num);
            map.put(num,count - 1);
            
            recurse(map,curr,N);
            map.put(num,count);
            curr.remove(curr.size() -1);
            
        }
    }

}