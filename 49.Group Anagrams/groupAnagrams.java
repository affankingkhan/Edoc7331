class Solution {
    List<List<String>> ret = new ArrayList<>();
    
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ret = new ArrayList<>();
        HashMap<String,Integer> map = new HashMap<>();
        
        int i = 0;
        for(String str : strs){
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String temp = new String(arr);
            if(map.containsKey(temp)){
                ret.get(map.get(temp)).add(str);
            }else{
                List<String> sub = new ArrayList<>();
                sub.add(str);
                ret.add(i,sub);
                map.put(temp,i);
                i++;
            }
            
        }
            
        return ret;
    }
    

    
    
}