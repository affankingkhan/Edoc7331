class Solution {
    public String frequencySort(String s) {
        Map<Character,Integer> map = new HashMap<>();
        
        // map the character to the count
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }
        
        // create a max heap of pairs where the key is the character and the value is count
        PriorityQueue<Pair<Character,Integer>> heap = new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());
        
        for(char c : map.keySet()){
            Pair<Character,Integer> p = new Pair<>(c, map.get(c));
            heap.offer(p);
        }
        
        String ret = "";
        // return the pair with the largest count and generate the string
        while(heap.peek() != null){
            Pair<Character,Integer> p = heap.poll();
            char c = p.getKey();
            int count = p.getValue();
            String sub = "" + c;
            sub = sub.repeat(count);
            ret += sub; 
        }
        return ret;
    }
}