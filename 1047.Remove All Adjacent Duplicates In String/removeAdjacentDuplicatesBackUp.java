//https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
class Solution {
    public String removeDuplicates(String s) {
        char [] charArr = s.toCharArray();
        int end = -1;
        for (char c: charArr) {
            if (end >= 0 && charArr[end] == c){
                --end;
            } else {
                charArr[++end] = c;
            }
        }
    return String.valueOf(charArr, 0, end+1);
    }
}