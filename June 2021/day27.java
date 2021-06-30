//https://leetcode.com/problems/candy/submissions/
class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
    
        int[] indexArr = new int[n];
        for(int i = 0; i < n; i++){
            indexArr[i] = i;
        }
        
        mergeSort(ratings,indexArr,0,n-1);
        
        int[] ans = new int[n];
        
        int counter = 0;
        
        for(int i = 0; i< n; i++){
            int ind = indexArr[i];
            int curr = 0;
            if(ind - 1 >= 0 && ratings[ind] != ratings[ind - 1]) curr = Math.max(ans[ind - 1], curr);
            if(ind + 1 < n && ratings[ind] != ratings[ind + 1]) curr = Math.max(ans[ind + 1], curr);
            ans[ind] = curr + 1;
            counter += ans[ind];
            
        }
        return counter;
        
        
    }
    
    private void mergeSort(int[] ratings, int[] indexArr, int left, int right){
        if(left == right) return;
        
        int M = (left + right) / 2;
        
        mergeSort(ratings,indexArr,left,M);
        mergeSort(ratings,indexArr,M+1,right);
        merge(ratings,indexArr,left,right,M);
        return;
    }
    
    private void merge(int[] ratings, int[] indexArr, int left, int right, int mid){
        int leftLength = mid - left + 1;
        int rightLength = right - mid;
        
        int[] leftArr = new int[leftLength];
        int[] rightArr = new int[rightLength];
        
        for(int i = 0; i< leftLength; i++){
            leftArr[i] = indexArr[left + i];
        }
        for(int i = 0; i< rightLength; i++){
            rightArr[i] = indexArr[mid + i + 1];
        }
        
        int i = 0, j = 0, k = left;
        
        while(i< leftLength && j < rightLength){
            if(ratings[leftArr[i]] <= ratings[rightArr[j]]){
                indexArr[k] = leftArr[i];
                i++;
            }
            else{
                indexArr[k] = rightArr[j];
                j++;
            }
            k++;
        }
        
        while(i < leftLength){
            indexArr[k] = leftArr[i];
            i++;
            k++;
        }
        
        while(j < rightLength){
            indexArr[k] = rightArr[j];
            j++;
            k++;
        }
        
        
        
    }
}