class Solution {
    public int[] minOperations(String boxes) {
        // return variable
        int[] ret = new int[boxes.length()];
        
        // set of all the indexes that contain a 1 on the left of the current index
        HashSet<Integer> left = new HashSet<>();
        // set of all the indexes that contain a 1 on the right of the current index
        HashSet<Integer> right = new HashSet<>();
        
        // sum on the left
        int leftSum = 0;
        // sum on the right
        int rightSum = 0;
        
        // for the first box, we need to go through all the boxes and populate the right set and right sum
        for(int i = 1; i<boxes.length(); i++){
            if(boxes.charAt(i) == '1'){
                right.add(i);
                rightSum += i;
            }
        }
        
        // if the first box is '1', we need to add it to the lefts set for the box[1]
        if(boxes.charAt(0) == '1'){
            left.add(0);
        }
        
        // set the value of the first total
        ret[0] = leftSum  + rightSum;
        
        
        // run through the logic for the rest of the boxes starting at index 1
        for(int i = 1; i<boxes.length(); i++){
            // if the current box is a '1', we need to removed it from the right set since it is not part of the right
            // left sum increases by the size of the elements to the left ie. all of them have to travel 1 more box
            // right sum decreases by how many elements are on the right. we need to subtract 1 more since since the current 1 is no longer on the right
            if(boxes.charAt(i) == '1'){
                right.remove(i);
                leftSum += left.size();
                rightSum -= right.size();
                rightSum--;
                ret[i] = leftSum + rightSum;
                left.add(i);
            }else{
                leftSum += left.size();
                rightSum -= right.size();
                ret[i] = leftSum + rightSum;
            }
        }
        
        return ret;
        
    }
}