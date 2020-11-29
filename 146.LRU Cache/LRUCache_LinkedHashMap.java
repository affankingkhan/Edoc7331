class LRUCache {
    private int capacity;
    private LinkedHashMap<Integer,Integer> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new LinkedHashMap<>(capacity);
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            moveRecent(key);
            return map.get(key);
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            map.put(key,value);
            moveRecent(key);
        }
        else{
            if(map.size() >= capacity){
                int old = map.keySet().iterator().next();
                map.remove(old);
            }
            map.put(key,value);
        }
    }
    
    private void moveRecent(int key){
        int val = map.get(key);
        map.remove(key);
        map.put(key,val);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */