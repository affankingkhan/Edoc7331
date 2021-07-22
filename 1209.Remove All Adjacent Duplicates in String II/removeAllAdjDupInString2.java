//https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/
class Solution {
    public String removeDuplicates(String s, int k) {
        
        char[] sCh = s.toCharArray();
        
        ArrayDeque<Pair<Character,Integer>> stack = new ArrayDeque<>();
        
        for(int i = 0; i < sCh.length; i++){
            char curr = sCh[i];
            Pair<Character,Integer> top = stack.peek();
            if(top == null){
                stack.push(new Pair<>(curr, 1));
            }else{
                if(top.getKey() == curr){
                    int prevVal = top.getValue();
                    if(prevVal + 1 == k){
                        stack.pop();
                        
                    }else{
                        stack.pop();
                        stack.push(new Pair<>(curr, prevVal +1));
                    }
                    
                }else{
                    stack.push(new Pair<>(curr, 1));
                }
                
            }
            
        }
        
        StringBuilder sb = new StringBuilder();
        
        while(!stack.isEmpty()){
            Pair<Character,Integer> p = stack.pop();
            char c = p.getKey();
            int val = p.getValue();
            
            for(int i=0; i< val; i++){
                sb.insert(0, c);
            }
        }
        
        return sb.toString();
        
    }
}