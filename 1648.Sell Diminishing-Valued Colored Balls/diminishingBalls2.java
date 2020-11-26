class Solution {
    public int maxProfit(int[] inventory, int orders) {
        // constant for Modding with
        int mod = 1000000007;
        // return value is long which we will cast to int
        long sum = 0;
        // this keeps track of current position of first largest element
        int n = inventory.length - 1;
        // need to sort
        Arrays.sort(inventory);
        // multiply this by summation. it increases by 1 every iteratio of while
        long count = 1;
            
        // while there are still orders
        while(orders > 0){
            
            if(n > 0 && inventory[n] > inventory[n - 1] && count * (inventory[n] - inventory[n - 1]) <= orders){
                sum += count * sumNtoI(inventory[n], inventory[n-1]);
                orders -= count * (inventory[n] - inventory[n - 1]);
            }
            
            else if (n == 0 || inventory[n] > inventory[n - 1]){
                long a = orders / count;
                sum += count * sumNtoI(inventory[n], inventory[n] - a);
                long b = orders % count;
                sum += b * (inventory[n]-a);
                orders = 0;
            }
            sum %= mod;
            count++;
            n--;
            
        }
        return (int) sum;
        
    }
    
    private long sumNtoI (long N, long I){
        return (N *(N+1) / 2) - (I*(I+1) / 2);
    }
}