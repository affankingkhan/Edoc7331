class Solution {
    public int countSquares(int[][] matrix) {
        
        int count = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int maxDim = Math.min(m,n);
        
        // we need two queues.
        // 1 will be the one we take from, and the other will be what we add to
        // roles of the the 2 queues alternate after every dimension
        ArrayDeque<String> q1 = new ArrayDeque<>();
        ArrayDeque<String> q2 = new ArrayDeque<>();
        
        for(int i = 0; i<m; i++){
            for(int j= 0; j<n; j++){
                if(matrix[i][j] == 1){
                    q1.offer(i + "a" + j);
                    count++;
                }
            }
        }
        
        for(int dim = 2; dim<=maxDim; dim++){
            // if both queues are empty, we are done
            if(q1.size() == 0 && q2.size() == 0) break;
            
            //curr is set to the queue that has elements
            //other is set to the queue that is empty
            ArrayDeque<String> curr = q1;
            ArrayDeque<String> other = q2;
            
            if(q1.size() == 0){
                curr = q2;
                other = q1;
            }
            
            // initialize current dimension count
            int dimCount = 0;
            
            // loop through each curr
            while(curr.peek() != null){
                // get the indexes from the queue
                String str = curr.poll();
                String[] indexes = str.split("a",2);
                
                //check if the coordinate is top left of a dim x dim valid matrix
                int currCount = isPartOfMatrixOfNDimension(matrix,Integer.parseInt(indexes[0]), Integer.parseInt(indexes[1]),m,n,dim);
                
                // if it is, add the index to the other queue which will be used for the next dim and increment dimCount
                if(currCount == 1){
                    other.offer(str);
                    dimCount++;
                }  
            }
            
            // if there are no dimCount we break since if there are no 3x3 matrix then there are no 4x4 
            
            if(dimCount == 0){
                break;
            }
            
            //increment count by dimCount
            
            count += dimCount;
            
            
        }
        
        return count;
        
    }
    
    private int isPartOfMatrixOfNDimension(int[][] matrix, int i, int j, int m, int n, int dim){
        int yEnd = i+ dim; 
        int xEnd = j+dim;
        if(xEnd > n || yEnd >m) return 0;
    
        
        for(int y = i; y< yEnd; y++){
            for(int x = j; x<xEnd; x++){
                if(matrix[y][x] == 0) return 0;
            }
        }
        
        return 1;
    }
    
}