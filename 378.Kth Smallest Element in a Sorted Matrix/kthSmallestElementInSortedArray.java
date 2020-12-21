class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b) -> b - a);
        int n = matrix.length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j<n; j++){
                heap.offer(matrix[i][j]);
                if(heap.size() > k){
                    heap.poll();
                }
            }
        }
        return heap.poll();
    }
}