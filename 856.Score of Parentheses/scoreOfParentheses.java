class Solution {
    public int scoreOfParentheses(String S) {
        Deque<String> stack = new ArrayDeque<>();
        
        for(char c : S.toCharArray()){
            if(c == '(') stack.push("(");
            else if(c == ')'){
                int sum = 0;
                while(stack.peek() != null){
                    String s = stack.pop();
                    if(s != "("){
                        sum += Integer.valueOf(s);
                    }else{
                        break;
                    }
                }
                
                if(sum > 0){
                    sum *= 2;
                }else{
                    sum = 1;
                }
                stack.push(Integer.toString(sum));
            }
        }
        
        int count = 0;
    
        while(stack.peek() != null){
            String s = stack.pop();
            count += Integer.valueOf(s);
        }
        
        return count;
        
    }
}