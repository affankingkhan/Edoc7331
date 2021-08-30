//https://leetcode.com/problems/sell-diminishing-valued-colored-balls/
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
            map.put(num, map.getOrDefault(num,0) + 1);
        }
        
        int currMax = max;
        
        while(orders > 0){
            int count = map.get(currMax);
            if(orders >= count){
                sum += (currMax * count);
                map.remove(currMax);
                orders -= count;
                
                currMax--;   
                map.put(currMax, map.getOrDefault(currMax,0) + count);
                
            }else{
                sum += orders * currMax;
                orders = 0;
                map.put(currMax, count - orders);
            }
            sum %= mod;
        }
        
        return (int)sum;
        
    }
}