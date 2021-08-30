//https://leetcode.com/problems/robot-bounded-in-circle/
class Solution {
    class Node{
        int x;
        int y;
        public Node(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    public boolean isRobotBounded(String instructions) {
        HashMap<String,ArrayList<String>> map2=new HashMap();
        HashMap<String,Node> map1=new HashMap();
        map1.put("North",new Node(0,1));
         map1.put("South",new Node(0,-1));
         map1.put("East",new Node(1,0));
         map1.put("West",new Node(-1,0));
        
  
        map2.put("North",new ArrayList(Arrays.asList( "West","East")));
         map2.put("South",new ArrayList(Arrays.asList( "East","West")));
         map2.put("East",new ArrayList(Arrays.asList( "North","South")));
         map2.put("West",new ArrayList(Arrays.asList( "South","North")));
        String currdir="North";
        Node curr=new Node(0,0);
        for(int i=0;i<instructions.length();i++){
            char ch=instructions.charAt(i);
            if(ch=='G'){
             curr.x=curr.x+map1.get(currdir).x; 
                 curr.y=curr.y+map1.get(currdir).y; 
            }
            else if(ch=='L'){
                currdir=map2.get(currdir).get(0);
            }
            else{
                currdir=map2.get(currdir).get(1); 
            }
        }
     
        
        if(curr.x==0 && curr.y==0)return true;
        else if(!currdir.equals("North"))return true;
        else return false;
    }
}