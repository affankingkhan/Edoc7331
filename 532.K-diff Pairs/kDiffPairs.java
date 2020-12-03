class Solution {
    public int findPairs(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n : nums){
            if(map.containsKey(n)){
                map.put(n,map.get(n)+1);
            }else{
                map.put(n,1);
            }
        }
        int count = 0;
        if(k == 0){
            Set<Integer> keys = map.keySet();
            for(int key : keys){
                if(map.get(key) > 1){
                    count++;
                }
            }
        }else{
            HashSet<Integer> set = new HashSet<>();
            for(int n : nums){
                int conjugate = n + k;
                if(k == 0){

                }
                if(!map.containsKey(conjugate) || map.get(conjugate) == 0 || set.contains(n)){
                    continue;
                }
                set.add(n);
                map.put(conjugate,map.get(conjugate) -1);
                count++;

            }
        }
        return count;
    }
}