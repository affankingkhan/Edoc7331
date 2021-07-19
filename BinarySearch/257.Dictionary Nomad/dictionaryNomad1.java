// https://binarysearch.com/problems/Dictionary-Nomad
import java.util.*;

class Solution {
    public int solve(String[] dictionary, String start, String end) {
        if (start.equals(end))
            return 0;
        if (start.length() != end.length())
            return -1;
        int n = dictionary.length;
        int m = start.length();

        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        int startIdx = 0;
        int endIdx = 0;

        for (int i = 0; i < n; i++) {
            if (dictionary[i].equals(start)) {
                startIdx = i;
            } else if (dictionary[i].equals(end)) {
                endIdx = i;
            }
            for (int j = i + 1; j < n; j++) {
                if (differByOneChar(dictionary[i].toCharArray(), dictionary[j].toCharArray(), m)) {
                    adj[i].add(j);
                    adj[j].add(i);
                }
            }
        }

        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.offer(startIdx);
        int ans = 1;
        Set<Integer> visited = new HashSet<>();

        while (!q.isEmpty()) {
            int levelCount = q.size();
            while (levelCount > 0) {
                levelCount--;
                int next = q.poll();
                if (visited.contains(next))
                    continue;
                visited.add(next);
                if (next == endIdx)
                    return ans;
                for (int x : adj[next]) {
                    if (!visited.contains(x))
                        q.offer(x);
                }
            }
            ans++;
        }

        return -1;
    }

    private boolean differByOneChar(char[] a, char[] b, int wordSize) {
        if (a.length != b.length)
            return false;
        if (a.length != wordSize)
            return false;
        int differCount = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i])
                differCount++;
            if (differCount > 1)
                return false;
        }
        return differCount == 1;
    }

    // private void printArr(char[] a){
    //     for(char c: a){
    //         System.out.print(c + " ");
    //     }
    //     System.out.println("");
    // }
}