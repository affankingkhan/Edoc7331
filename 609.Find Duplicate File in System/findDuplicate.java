class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        // map the content to a list of directories
        HashMap<String, List<String>> map = new HashMap<>();
        
        for(String path: paths){
            String[] buffer = path.split(" ");
            if(buffer.length < 2){
                continue;
            }
            String directory = buffer[0]; 
            for(int i = 1; i<buffer.length; i++){
                String[] arr = this.extractFileInfo(buffer[i]);
                
                List<String> list = map.getOrDefault(arr[1], new ArrayList<>());
                list.add(directory + '/'+ arr[0]);
                map.put(arr[1], list);
            }
        }
        
        List<List<String>> ret = new ArrayList<>();
        
        for(String content: map.keySet()){
            if(map.get(content).size() > 1){
                ret.add(map.get(content));
            }
        }
        return ret;
        
        
    }
    
    
    private String[] extractFileInfo(String fileInfo){ 
        String[] info = fileInfo.split("\\(",2);
        info[1] = info[1].replace(")", "");
        return info;
        
    }
    
}