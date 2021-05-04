class Trie{
    class Node {
        char ch = '\0';
        boolean isWord = false;
        Node[] children = new Node[26];
        Node(char c){
            this.ch = c;
        }

    }
    
    Node curr;
    Node root;
    
    List<String> buffer;
    
    Trie(){
        this.root = new Node('\0');
    }
    
    public void insert(String s){
        this.curr = this.root;
        
        for(char c : s.toCharArray()){
            if(this.curr.children[c - 'a'] == null){
                this.curr.children[c - 'a'] = new Node(c);
            }
            this.curr = this.curr.children[c - 'a'];
        }
        
        this.curr.isWord = true;
        
    }
    
    
    public List<String> fetchSuggestions(String prefix){
        this.curr = this.root;
        this.buffer = new ArrayList<>();
    
        for(char c : prefix.toCharArray()){
            if(this.curr.children[c - 'a'] == null){
                return this.buffer;
            }
            this.curr = this.curr.children[c - 'a'];
        }
        this.dfs(this.curr,prefix);
        return this.buffer;
        
    }
    
    private void dfs(Node node, String s){
        if(this.buffer.size() >= 3) return;
        if(node == null) return;
        
        if(node.isWord) this.buffer.add(s);
        
        for(int i = 0; i< node.children.length; i++){
            if(node.children[i] != null){
                dfs(node.children[i], s + ((char)('a' + i)));
            }
        }
    }
    
}


class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        
        Trie trie = new Trie();
        
        for(String product : products){
            trie.insert(product);
        }
        
        List<List<String>> ret = new ArrayList<>();
        
        StringBuilder str = new StringBuilder();
        for(char c : searchWord.toCharArray()){
            str.append(c);
            ret.add(trie.fetchSuggestions(str.toString()));
        }
        return ret;
        
    }
}