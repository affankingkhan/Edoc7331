class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        
        for(int i = 0 ; i< m; i++){
            int j = i;
            int k = 0; // first column
            
            PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b );
            
            while(j < m && k < n ){
                minHeap.offer(mat[j][k]);
                j++;
                k++;
            }
            
            j = i;
            k = 0;
            
            while(j < m && k < n ){
                mat[j++][k++] = minHeap.poll(); 
            }
        }

        for(int i = 1 ; i < n ; i++){
            int j = 0; // first row
            int k = i;

            PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b );
            
            while(j < m && k < n ){
                minHeap.offer(mat[j][k]);
                j++;
                k++;
            }
            
            j = 0;
            k = i;
            
            while(j < m && k < n ){
                mat[j++][k++] = minHeap.poll(); 
            }
        }
        
        return mat;
    }
}