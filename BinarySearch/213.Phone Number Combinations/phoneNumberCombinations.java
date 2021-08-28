// https://binarysearch.com/problems/Phone-Number-Combinations
import java.util.*;

class Solution {
    HashMap<Character, char[]> map;
    List<String> strList;
    public String[] solve(String digits) {
        map = new HashMap();
        map.put('2', new char[] {'a', 'b', 'c'});
        map.put('3', new char[] {'d', 'e', 'f'});
        map.put('4', new char[] {'g', 'h', 'i'});
        map.put('5', new char[] {'j', 'k', 'l'});
        map.put('6', new char[] {'m', 'n', 'o'});
        map.put('7', new char[] {'p', 'q', 'r', 's'});
        map.put('8', new char[] {'t', 'u', 'v'});
        map.put('9', new char[] {'w', 'x', 'y', 'z'});

        strList = new ArrayList();

        recurse(new StringBuilder(), digits);

        String[] ret = new String[strList.size()];

        for (int i = 0; i < ret.length; i++) {
            ret[i] = strList.get(i);
        }
        return ret;
    }

    private void recurse(StringBuilder curr, String digits) {
        if (curr.length() == digits.length()) {
            strList.add(curr.toString());
            return;
        }

        int len = curr.length();

        char c = digits.charAt(len);

        char[] letters = map.get(c);

        for (char ch : letters) {
            curr.append(ch);
            recurse(curr, digits);
            curr.deleteCharAt(curr.length() - 1);
        }
        return;
    }
}