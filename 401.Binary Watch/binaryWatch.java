class Solution {
    List<String> ret;
    public List<String> readBinaryWatch(int num) {
        ret = new ArrayList<>();
        
        recurse(new ArrayList<>(), num, 0);
        return ret;
        
    }
    
    // on is the list of all the LED indexes that are ON
    private void recurse(List<Integer> on,int num, int pos){
        if(on.size() == num){
            String time = generateTime(on);
            if(time != null){
                ret.add(time);
            }
            return;
        }
        
        for(int i = pos; i < 10; i++){
            // make decision
            on.add(i);
            //recrsive step
            recurse(on, num, i+1);
            //back track
            on.remove(on.size()-1);
        }
    }
    
    private String generateTime(List<Integer> on){
        String Hrs = "";
        String Mins = "";
        
        int hour = 0;
        int min = 0;
        
        for(int idx : on){
            if(idx <= 3){
                hour += Math.pow(2,idx);
            }else{
                idx -= 4;
                min += Math.pow(2,idx);
            }
        }
        
        if(min > 59 || hour >11){
            return null;
        }
        
        Hrs += Integer.toString(hour);
        if(min < 10){
            Mins = "0";
        }
        Mins += Integer.toString(min);
        return Hrs + ":" + Mins;
        
    }
}