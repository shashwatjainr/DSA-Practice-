import java.util.Arrays;
import java.util.Scanner;

public class Max_Of_Array {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i= 0; i<n; i++){
            arr[i]= scn.nextInt();
        }
        maxOfArray(arr,0);
    }
    
    public static int maxOfArray(int[] arr, int idx){
        if(idx==arr.length){return 0;}
        int max = arr[arr.length];
        max = max<arr[idx]?arr[idx]:max;
        maxOfArray(arr, idx+1);
        return max; 
    }
}

