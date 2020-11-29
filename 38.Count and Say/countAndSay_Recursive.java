class Solution {
    public String countAndSay(int n) {
        if(n == 1){
            return "1";
        }
        String cs = countAndSay(n-1);
        return say(cs);
    }
    
    private String say(String s){
        char[] ch = s.toCharArray();
        String ret = "";
        char curr = ch[0];
        int currCount = 0;
        for(char c : ch){
            if(c == curr){
                currCount++;
            }else{
                ret += Integer.toString(currCount);
                ret += curr;
                curr = c;
                currCount = 1;
            }
        }
        ret += Integer.toString(currCount);
        ret += curr;
        return ret;
        
    }
}