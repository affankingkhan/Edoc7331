class Solution {
    public int openLock(String[] deadends, String target) {
        
        HashSet<String> dead = new HashSet<>(Arrays.asList(deadends));
        
        ArrayDeque<String> queue = new ArrayDeque<>();
        queue.offer("0000");
        int level = 0;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size > 0){
                String curr = queue.poll();
                
                if(dead.contains(curr)){
                    size--;
                    continue;
                }
                if(curr.equals(target)){
                    return level;
                }
                
                StringBuilder sb = new StringBuilder(curr);
                for(int i = 0; i< 4; i++){
                    char c = sb.charAt(i);
                    
                    String up = sb.substring(0,i) + (c == '9' ? 0 : c - '0' + 1) + sb.substring(i+1);
                    if(!dead.contains(up)){
                        queue.offer(up);
                    }
                    String down = sb.substring(0,i) + (c == '0' ? 9 : c - '0' - 1) + sb.substring(i+1);
                    if(!dead.contains(down)){
                        queue.offer(down);
                    }
                    
                }
                dead.add(curr);
                size--;
            }
            
            level++;
        }
        
        return -1;
        
        
    }
}