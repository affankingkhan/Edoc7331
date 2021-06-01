class Solution {
    public String minRemoveToMakeValid(String s) {
        
        // two stack approach 
        
        ArrayDeque<Character> s1 = new ArrayDeque<>();
        ArrayDeque<Character> s2 = new ArrayDeque<>();
        
        for(char c : s.toCharArray()){
            if(c == '('){
                s1.push(c);
                s2.push(c);
            }
            else if(c == ')'){
                if(s2.size() >= 1){
                    s2.pop();
                    s1.push(c);
                }
                
            }else{
                s1.push(c);
            }
            
        }
        
        StringBuilder ret = new StringBuilder();
        while(s1.size() > 0){
            char c = s1.pop();
            if(c == '('){
                if(s2.size() > 0){
                    s2.pop();
                }else{
                    ret.insert(0,c);
                }
                
            }else{
                ret.insert(0,c);
            }
            
        }
        return ret.toString();
    }
}