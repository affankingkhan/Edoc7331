class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        
        while(i < j){
            int sum = numbers[i] + numbers[j];
            if(sum == target){
                return new int[] {i+1, j+1};
            }
            else if (sum < target){
                int sameVal = numbers[i];
                while(i < j && numbers[i] == sameVal){
                    i++;
                }
            }
            else if (sum > target){
                int sameVal = numbers[j];
                while(i < j && numbers[j] == sameVal){
                    j--;
                }
            }
        }
        return new int[] {0, 0};
    }
}