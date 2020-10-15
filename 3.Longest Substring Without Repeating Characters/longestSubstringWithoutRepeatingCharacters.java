// import java.util.HashMap; // import the HashMap class
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int currCount = 0;
        int currStart = 0;
        
        for(int i = 0; i<s.length(); i++){
            // store char in a variable
            char cha = s.charAt(i);
            // if you haven't come across the character
            if(!map.containsKey(cha)){
                map.put(cha, i);
                currCount++;
                max = Math.max(max, currCount);
            }
            // if you have come across the character before
            else{
                int trouble = map.get(cha);
                //if the trouble character is before the current start we don't need 
                //to worry about it. just update map and increment currCount.
                if(currStart > trouble){
                    map.put(cha, i);
                    currCount++;
                    max = Math.max(max, currCount);
                }
                // if the trouble character is at or after the currStart, currStart
                // should just be 1 head of trouble and the currCount is the
                //difference between i and currStart + 1
                else{
                    currStart = trouble + 1;
                    map.put(cha, i);
                    currCount = i - currStart + 1;
                    
                }
            }
            
        }
        
        return max;
        
    }
}