class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        String ret = "";
        
        Map<String,String> map = new HashMap<>();
        
        for(List<String> lis : knowledge){
            map.put(lis.get(0), lis.get(1));
        }
        
        int i = 0;
        boolean inBracket = false;
        
        String word = "";
        
        while(i< s.length()){
            char c = s.charAt(i);
            if(c == '('){
                inBracket = true;
            }
            else if (c == ')'){
                inBracket = false;
                
                ret += (map.get(word) != null) ? map.get(word) : "?";
                word = "";
            }
            else{
                if(inBracket){
                    word += c;
                }else{
                    ret += c;
                }
            }
            i++;
        }
        
        return ret;
        
    }
}