class Solution {
    class Trie{
        class Node{
            boolean isFolder = false;
            HashMap<String,Node> children = new HashMap<>();
            String folder;
            
            Node(String folder){
                this.folder = folder;
            }
        }
        
        Node root;
        Node curr;
        
        List<String> buffer;
        
        Trie(){
            // empty string for folder
            this.root = new Node("");
        }
        
        // this method return the folders we want by running a dfs
        public List<String> fetchRootFolder(){
            this.curr = this.root;
            this.buffer = new ArrayList<>();
            dfs(curr, "");
            return buffer;
        }
        
        // dfs on the trie
        private void dfs(Node node, String dir){
            if(node == null) return;
            if(node.isFolder){
                buffer.add(dir);
                return;
            }
            
            if(dir != ""){
                dir += "/";
            }
            for(String key: node.children.keySet()){
                dfs(node.children.get(key),  dir + key);
            }
            
            return;
            
        }
        
        // insert a folder into the trie
        public void insert(String directory){
            this.curr = this.root;
            String[] arr = directory.split("/");
            for(String s : arr){
                if(s == null || s == ""){
                    continue;
                }
                if(curr.children.get(s) == null){
                    curr.children.put(s, new Node(s));
                }
                curr = curr.children.get(s); 
            }
            
            curr.isFolder = true;
            
        }
        
    }
    
    public List<String> removeSubfolders(String[] folder) {
        
        Trie t = new Trie();
        for(String f: folder){
            t.insert(f);
        }
        List<String> ret = t.fetchRootFolder();
        return ret;
        
    }
}