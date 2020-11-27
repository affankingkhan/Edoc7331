class Solution {
    public int singleNumber(int[] nums) {
        Set<Integer>set = new HashSet<>();
        for(int num : nums){
            if(set.contains(num)){
                set.remove(num);
            }else{
                set.add(num);
            }
        }
        Iterator<Integer> it = set.iterator();
        
        while(it.hasNext()){
            return it.next();
        }
        return 0;
        
    }
}