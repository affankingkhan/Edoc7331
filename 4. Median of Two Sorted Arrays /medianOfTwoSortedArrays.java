class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        
        int total = len1 + len2;
        
        boolean isEven = (total % 2 == 0);
            
        int valueToGoUpTo = total / 2;
        
        int j = -1;
        int k = -1;
        
        double[] subArr = new double[valueToGoUpTo + 1];
        
        for(int i = 0; i<= valueToGoUpTo; i++){
            if(j+1 < len1 && k+1 < len2 ){
                if(nums1[j+1] <= nums2[k+1]){
                    subArr[i] = (double) nums1[++j];
                }else{
                    subArr[i] = (double) nums2[++k];
                }   
            }
            else if (j+1 < len1){
                subArr[i] = (double) nums1[++j];
            }else{
                subArr[i] = (double) nums2[++k];
                
            }
        }
        double max = subArr[valueToGoUpTo];
        
        if(subArr.length <= 1){
            return max;
        }
        double maxbelow = subArr[valueToGoUpTo-1];
        
        
        return (isEven) ? ((max + maxbelow) / 2) : max;
        
        
    }
}