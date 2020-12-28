class Solution {
    
    class KVPair {
        int index;
        double distance;
        public KVPair(int i, double d){
            this.index = i;
            this.distance = d;
        }
    }
    
    public int[][] kClosest(int[][] points, int K) {
        int[] origin = {0,0};
        
        PriorityQueue<KVPair> heap = new PriorityQueue<KVPair>((a,b) -> compare(b,a));
        
        for(int i = 0; i< points.length; i++){
            int[] cor = points[i];
            double distance = calculateEuclideanDistance(cor,origin);
            KVPair node = new KVPair(i,distance);
            heap.offer(node);
            if(heap.size() > K){
                heap.poll();
            }
        }
        
        int[][] ret = new int[K][2];
        for(int i = 0; i<K; i++){
            KVPair node = heap.poll();
            ret[i] = points[node.index];
        }
        
        return ret;
    }
    
    private int compare(KVPair a, KVPair b){
        if(a.distance < b.distance){
            return -1;
        }
        else if (a.distance > b.distance){
            return 1;
        }
        return 0;
    }
    
    private double calculateEuclideanDistance(int[] cor, int[] other){
        
        int x = cor[0] - other[0];
        int y = cor[1] - other[1];
        
        return Math.sqrt((x*x) + (y*y));
    }
}