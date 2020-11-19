class Solution {
    public List<String> letterCombinations(String digits) {
        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        
        List<String> ret = new ArrayList<>();
        char[] input = digits.toCharArray();
            
        for(char dig : input){
            String letters = map.get(dig);
            String[] lettersArr = letters.split("");
            if(ret.isEmpty()){
                for(String letter : lettersArr){
                    ret.add(letter);
                }
            }else{
                List<String> newRet = new ArrayList<>();
                for(String start : ret){
                    for(String letter : lettersArr){
                        String s = start + letter;
                        newRet.add(s);
                    }
                }
                ret = newRet;
            }
            
            
        }
        return ret;
        
        
        
    }
}