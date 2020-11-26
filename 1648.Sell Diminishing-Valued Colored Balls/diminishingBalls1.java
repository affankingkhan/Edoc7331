class Solution {
    public int maxProfit(int[] inventory, int orders) {
        int mod = 1000000007;
        long sum = 0;
        int max = Integer.MIN_VALUE;
        
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i = 0; i<inventory.length; i++){
            int num = inventory[i];
            if(num > max){
                max = inventory[i];
            }
            if(map.containsKey(num)){
                map.put(num, map.get(num) + 1);
            }else{
                map.put(num, 1);
            }
        }
        
        int currMax = max;
        
        while(orders > 0){
            int count = map.get(currMax);
            if(orders >= count){
                sum += (currMax * count);
                map.remove(currMax);
                
                if(map.containsKey(currMax - 1 )){
                    map.put(currMax - 1, map.get(currMax - 1) + count);
                }else{
                    map.put(currMax - 1, count);
                }
                currMax--;
                orders -= count;
                
            }else{
                sum += currMax;
                map.put(currMax, map.get(currMax) - 1);
                
                if(map.containsKey(currMax - 1 )){
                    map.put(currMax - 1, map.get(currMax - 1) + 1);
                }else{
                    map.put(currMax - 1, 1);
                }
                orders -= 1;
            }
            sum %= mod;
        }
        
        return (int)sum;
        
    }
}