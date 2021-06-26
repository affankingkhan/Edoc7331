//https://leetcode.com/problems/count-of-smaller-numbers-after-self/submissions/
//https://www.youtube.com/watch?v=VOv2vY_Hq8Y

class Solution {
    int[] count;
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        count = new int[n];
        
        // this index array representes the indexes of all the values in nums.
        // we will sort this array with merge sort according to the values in nums.
        // eg 5,2,6,1 will start out as 0,1,2,3 but will be sorted to 3102.
        // we are shuffling the indexes
        int[] indexArr = new int[n];
        for(int i = 0; i<n; i++){
            indexArr[i] = i;
        }
        
        mergeSort(nums,indexArr,0,n-1);
        
        List<Integer> ret = new ArrayList<>();
        
        for(int c : count){
            ret.add(c);
        }
        return ret;
        
    }
    
    //simple merge sort algo
    private void mergeSort(int[]nums, int[] indexArr, int left , int right){
        if(left == right) return;
        
        int mid = (left + right) /2;
        
        mergeSort(nums,indexArr, left, mid);
        mergeSort(nums,indexArr, mid + 1, right);
        merge(nums,indexArr, left, right, mid);
        return;
    }
    
    
    private void merge(int[]nums, int[] indexArr, int left , int right, int mid){
        int leftLength = mid - left + 1;
        int rightLength = right - mid;
        
        // create the 2 left and right sub arrays and populate with indexArr values
        int[] leftArr = new int[leftLength];
        int[] rightArr = new int[rightLength];
        
        for(int i = 0; i< leftLength; i++){
            leftArr[i] = indexArr[left + i];
        }
        
        for(int i = 0; i< rightLength; i++){
            rightArr[i] = indexArr[mid + i + 1];
        }
        
        // right counter is incremeneted every time we add from the right subArray
        // when we add the element from the left, we need to see how many elements we have added
        //previously from the right. This will be how many jumps  the element makes
        int i = 0, j = 0, k = left, rightCounter = 0;
        
        while(i < leftArr.length && j< rightArr.length){
            //if the next element is from the left, we need to
            // we need to increment count[leftArr[i]] bt rightCounter
            if(nums[leftArr[i]] <= nums[rightArr[j]] ){
                indexArr[k] = leftArr[i];
                count[leftArr[i]] += rightCounter;
                i++;
                
            }
            //if the next element is from the right
            // we need to increment rightCounter;
            else{
                indexArr[k] = rightArr[j];
                rightCounter++;
                j++;
                
            }
            k++;
        
        }
        
        //1 array might be longer than the other so this ensures the remaining elements are
        //populated correctly 
        while(i< leftArr.length){
            indexArr[k] = leftArr[i];
            count[leftArr[i]] += rightCounter;
            i++;
            k++;
        }
        
        while(j< rightArr.length){
            indexArr[k] = rightArr[j];
            rightCounter++;
            j++;
            k++;
        }
        
    }
}