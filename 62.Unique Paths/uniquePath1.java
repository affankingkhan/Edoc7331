class Solution {
    int count = 0;
    
    public int uniquePaths(int m, int n) {
        HashMap<Character,Integer> map = new HashMap<>();
        map.put('D', m-1);
        map.put('R', n-1);
        recurse(map,new ArrayList<>(), m+n-2);
        return count;
        
        
    }
    
    private void recurse(HashMap<Character,Integer> map, List<Character> curr, int N){
        if(curr.size() == N){
            count++;
            return;
        }
        
        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            char direction = entry.getKey();
            int counter = entry.getValue();
            if(counter == 0){
                continue;
            }
            //make a decision
            curr.add(direction);
            map.put(direction, counter -1);
            //recursive call
            recurse(map,curr,N);
            //backtrack
            map.put(direction, counter);
            curr.remove(curr.size() -1);
        }
    }
    
    
}