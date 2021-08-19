/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
public class Main
{

  public static int[] MoveZeroesToCenter (int[]nums)
  {
      int n = nums.length;
      
      int count = 0 ;
      for(int num : nums){
          if(num == 0) count++;
      }
      
      if(count == 0) return nums;
      
      int M = (n -1) / 2;
      count--;
      int low = M;
      int high = M;
      
      while(count > 0){
          if(count > 1){
              low--;
              high++;
              count -= 2;
          }else{
              high++;
              count--;
          }
      }
      
      int[] ret = new int[n];
      
      int i = 0;
      int j = 0;
      
      while(i < n && j < n){
          if(isZeroIndex(i, low, high)) i++;
          else{
              if(nums[j] == 0) j++;
              else{
                  ret[i++] = nums[j++];
              }
          }
      }
      
      return ret;
      
  }
  
  public static boolean isZeroIndex(int i, int x, int y){
      return i >= x && i<= y;
  }
  
  public static void moveZeroRight(int[] nums, int start, int end){
      int i = start;
      int j = start;
      
      while(j <= end){
            if(nums[i] != 0 && nums[j] != 0){
                i++;
                j++;
            }
            else if(nums[j] == 0) j++;
            else{
                swap(j, i, nums);
                i++;
                j++;
                
            }
        }
      
  }
  
  public static void moveZeroLeft(int[] nums, int start, int end){
      int i = end;
      int j = end;
      
      while(j >= start){
            if(nums[i] != 0 && nums[j] != 0){
                i--;
                j--;
            }
            else if(nums[j] == 0) j--;
            else{
                swap(j, i, nums);
                i--;
                j--;
                
            }
        }
      
  }

  public static void swap (int a, int b, int[]nums)
  {
    int temp = nums[b];
    nums[b] = nums[a];
    nums[a] = temp;
  }
  public static void printArr (int[]nums)
  {
    for(int n : nums){
        System.out.print(n + " ");
    }
    System.out.println("");
  }
  public static void main (String[]args)
  {
      int[] test = {0,0,0,0,0,0,0};
      int[] ans = MoveZeroesToCenter(test);
      printArr(ans);
      
      
  }
}
