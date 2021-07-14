// https://binarysearch.com/problems/Course-Scheduling
import java.util.*;

class Solution {

    boolean[] black, gray;
    public boolean solve(int[][] courses) {
        int n = courses.length;
        black = new boolean[n];
        gray = new boolean[n];

        for(int i = 0; i< n; i++){
            if(!black[i] && dfsCycle(courses, i)) return false;
        }
        return true;

        
    }

    private boolean dfsCycle(int[][] courses, int curr){

        if(gray[curr]) return true;

        gray[curr] = true;
        
        int[] courseArr = courses[curr];

        boolean brokeEarly = false;
        for(int i : courseArr){
            if(black[i]) continue;
            if(dfsCycle(courses, i)){
                brokeEarly = true;
                break;
            }
        }
        gray[curr] = false;
        black[curr] = true;

        return brokeEarly;

    }

    private void printArr(boolean[] arr){
        for(boolean i : arr){
            System.out.print(i + " ");
        }
        System.out.println(" ");

    }

    private void printArr(int[] arr){
        for(int i : arr){
            System.out.print(i + " ");
        }
        System.out.println(" ");

    }
}