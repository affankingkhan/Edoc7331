// https://binarysearch.com/problems/Repeating-String
import java.util.*;

class Solution {
    public boolean solve(String s) {
        // int n = s.length();
        // char[] sCh = s.toCharArray();

        // String word = "";
        // for(int i = 0; i< n; i++){
        //     if(i == 0){
        //         word += sCh[i];
        //         continue;
        //     }
        //     int k = s.indexOf(word, i);
        //     if(k == -1) return false;
        //     if(k == i ){
        //         if(checkIfWordRepeat(sCh, word)) return true;
        //     }
        //     word += sCh[i];
        // }
        // return false;

        for (int i = 1; i <= s.length() / 2; i++) {
            if (s.length() % i != 0)
                continue;
            StringBuilder b = new StringBuilder();

            if (i == 1) {
                b.append(s.substring(1));
                b.append(s.charAt(0));
            } else {
                b.append(s.substring(i));
                b.append(s.substring(0, i));
            }
            if (s.equals(b.toString()))
                return true;
        }
        return false;
    }

    // private boolean checkIfWordRepeat(char[] s, String word){
    //     char[] w = word.toCharArray();
    //     int n = s.length;
    //     int len = w.length;
    //     int i = 0;
    //     while(i < n){
    //         for(int j=0; j < len;j++){
    //             if(i >= n || s[i] != w[j]) return false;
    //             i++;
    //         }
    //     }
    //     return true;

    // }
}