class Solution {
    private class KeyCount {
        int key;
        int count;

        public KeyCount(int key, int count){
            this.key = key;
            this.count = count;
        }
    }
    
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num,map.getOrDefault(num, 0) + 1);
        }
        
        PriorityQueue<KeyCount> heap = new PriorityQueue<>((a,b) -> a.count - b.count);
        
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            KeyCount kc = new KeyCount(entry.getKey(),entry.getValue());
            heap.offer(kc);
            if(heap.size() > k){
                heap.poll();
            }
        }
        
        int[] ret = new int[k];
        
        for(int i = 0; i < k; i++){
            ret[i] = heap.poll().key;
        }
        return ret;
        
    }
}