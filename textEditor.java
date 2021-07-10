// https://leetcode.com/discuss/interview-question/860501/text-editor-implementation
import java.util.*;

class Solution {
    public String textEditor(String[] operations) {
        StringBuilder sb = new StringBuilder();

        ArrayDeque<String> stack  = new ArrayDeque<>();

        String clipBoard = "";
        
        for(String operation: operations){
            String[] curr = operation.split(" ", 2);
            if(curr[0].equals("INSERT")){
                sb.append(curr[1]);
                stack.push(curr[1]);
                stack.push(curr[0]);

            }
            else if(curr[0].equals("DELETE") && sb.length() > 0){
                stack.push(sb.substring(sb.length() -1));
                sb.deleteCharAt(sb.length() - 1);
                stack.push(curr[0]);

            }

            else if(curr[0].equals("COPY")){
                int i = Integer.parseInt(curr[1]);
                if(i >= sb.length()){
                    clipBoard = "";
                }else{
                    clipBoard = sb.substring(i).toString();
                }


            }

            else if(curr[0].equals("PASTE") && clipBoard.length() > 0){
                sb.append(clipBoard);
                stack.push(clipBoard);
                stack.push(curr[0]);

            }

            else if(curr[0].equals("UNDO")){
                if(!stack.isEmpty()){
                     String newOp = stack.pop();
                     String newEl = stack.pop();
                    
                    if(newOp.equals("INSERT") || newOp.equals("PASTE")){
                        int len = newEl.length();
                        sb.delete(sb.length() - len, sb.length());

                    }
                    else if(newOp.equals("DELETE")){
                        sb.append(newEl);
                        
                    }

                }


            }
        }

        return sb.toString();

    }
}