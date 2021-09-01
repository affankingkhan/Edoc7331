//https://leetcode.com/problems/reorganize-string/submissions/
class Solution {
    public String reorganizeString(String s) {
        
        int[] map = new int[26];
        
        for(char c: s.toCharArray()){
            map[c-'a']++;
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[1] - a[1]);
        
        for(int i = 0; i < 26; i++){
            if(map[i] != 0){
                pq.offer(new int[]{i, map[i]});
            }
        }
        
        StringBuilder ret = new StringBuilder();
        
        while(pq.size() > 1){
            int[] first = pq.poll();
            int[] second = pq.poll();
            
            char f = (char) (first[0] + 97);
            char c = (char) (second[0] + 97);
            
            int fCount = first[1];
            int sCount = second[1];
            
            ret.append(f);
            ret.append(c);
            sCount--;
            fCount--;
            
            if(fCount > 0){
                first[1] = fCount;
                pq.offer(first);
            }
            if(sCount > 0){
                second[1] = sCount;
                pq.offer(second);
            }
            
        }
        
        if(!pq.isEmpty()){
            int[] curr = pq.poll();
            if(curr[1] > 1) return "";
            ret.append((char) (curr[0] + 97));
        }
        
        return ret.toString();
        
        
    }
}