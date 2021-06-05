class Solution {
    public int countTriplets(int[] arr) {
        int count=0;
        
        for(int i=0;i<arr.length;i++)
        {
            int Xor=0;
            for(int j=i;j<arr.length;j++)
            {
                Xor^=arr[j];
                if(Xor==0)
                {
                    count+=(j-i);
                }
            }
        }
        return count;
        
    }
}