/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
public class Main
{
    
    public static void moveFailingGradesEnd(int[] grades){
        
        int n = grades.length;
        
        int curr = 0;
        int ahead = 0;
        
        
        while(ahead < n){
            if(!isFail(grades[curr]) && !isFail(grades[ahead])){
                ahead++;
                curr++;
            }
            else if(isFail(grades[ahead])){
                ahead++;
            }
            else{
                swap(grades,curr, ahead);
                curr++;
                ahead++;
            }
            
        }
        return;
        
        
        
    }
    
    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public static boolean isFail(int grade){
        return grade < 50;
    }
    
    public static void printArr(int[] arr){
        System.out.println("");
        for(int n : arr){
            System.out.print(n +" ");
        }
    }
	public static void main(String[] args) {
		int[] grades = {5,10,15,33,20,49,22,40,12};
		moveFailingGradesEnd(grades);
		printArr(grades);
		
	}
}
