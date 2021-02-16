class LRUCache {
    private class Node {
        int key = 0;
        int value = 0;
        
        Node prev = null;
        Node next = null;
        
        Node(int k, int v){
            this.key = k;
            this.value = v;
        }
    }
    
    HashMap<Integer,Node> cache = new HashMap<>();
    int capacity = 0;
    int size = 0 ;
    Node head = null;
    Node tail = null;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
    }
    
    public int get(int key) {
        if(this.cache.containsKey(key)){
            Node node = this.cache.get(key);
            deleteNode(node);
            addEnd(new Node(key,node.value));
            return node.value;
            
        }else{
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if(this.cache.containsKey(key)){
            Node node = this.cache.get(key);
            deleteNode(node);
            addEnd(new Node(key,value));
        }else{
            if(this.size == this.capacity){
                deleteNode(this.head);
                addEnd(new Node(key,value));
            }else if (this.size < this.capacity){
                addEnd(new Node(key,value));
            }
            
        }
    }
    
    private void addEnd(Node node){
        this.cache.put(node.key, node);
        
        if(this.size == 0){
            this.head = node;
            this.tail = node;
        }else{
            this.tail.next = node;
            node.prev = this.tail;
            this.tail = node;
        }
        this.size++;
    }
    
    private void deleteNode(Node node){
        //remove from the cache
        this.cache.remove(node.key);
        
        if(this.size == 1){
            this.head = null;
            this.tail = null;
        }
        else{
            if(node == this.head){
                removeHead();
            }
            else if (node == tail){
                removeTail();
            }
            else{
                Node prev = node.prev;
                Node next = node.next;
                prev.next = next;
                next.prev = prev;
            }
            
        }
        
        this.size--;
        return;
        
    }
    
    private void removeHead(){
        this.head = this.head.next;
        this.head.prev = null;
        return;
    }
    private void removeTail(){
        this.tail = this.tail.prev;
        this.tail.next = null;
        return;
    }
    
    
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */