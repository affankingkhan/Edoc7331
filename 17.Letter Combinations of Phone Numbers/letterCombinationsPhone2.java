class Solution {
    HashMap<Character, String> map = new HashMap<>();{{
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }};
    
    List<String> ret = new ArrayList<>();
    
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0){
            return ret;
        }
        
        backtrack(digits,"", 0);
        return ret;
    }
    
    private void backtrack(String digits, String curr,int pos){
        if(curr.length() == digits.length()){
            ret.add(curr);
            return;
        }
        
        char[] decisions = map.get(digits.charAt(pos)).toCharArray();
        
        for(int i = 0; i<decisions.length; i++){
            curr += decisions[i];
            backtrack(digits,new String(curr), pos+1);
            curr = curr.substring(0,curr.length() - 1);
        }
    }
    
    
}