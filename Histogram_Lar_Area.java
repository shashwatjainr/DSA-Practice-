import java.util.Arrays;
import java.util.Stack;
import java.util.Scanner;

public class Histogram_Lar_Area {
    public static void main (String [] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        int[] arer= new int[n];
        int[] arel= new int[n];

        for(int i=0; i<n; i++){
            arr[i]= scn.nextInt();
        }

        Stack<Integer> sl = new Stack<>();
        Stack<Integer> sr = new Stack<>();
        
        sl.push(0);
        sr.push(n-1);
        arel[0] = 0;
        arer[n-1] = 0;
        
        for(int i = 1; i<n; i++){
            
            while(!sl.isEmpty() && arr[i]<arr[sl.peek()]){
                sl.pop();
            }
            if(sl.isEmpty()){
                arel[i]=i;
            }else{
                arel[i]=i-sl.peek()-1;
            }
            sl.push(i);
            while(!sr.isEmpty() && arr[n-i-1]<arr[sr.peek()]){
                sr.pop();
            }
            if(sr.isEmpty()){
                arer[n-i-1]=i;
            }else{
                arer[n-i-1]= sr.peek()-n+i;
            }
            sr.push(n-i-1);
        }

        int max=(arel[0]+arer[0]+1)*arr[0];
        int area = 0;

        for(int k = 0; k<n; k++){
            area =(arel[k]+arer[k]+1)*arr[k];
            if(area > max) {max=area;}
        }
        System.out.println(max);
    }
}

// another approach that gpt suggested was to calculate the area
// of the elements / heights that are being popped. This way we 
// would be calculating the are respective to the maximum possible
// heights only. This approach reduces space complexity.

//for(int i = 0; i <= n; i++) {
//            int currentHeight = (i == n) ? 0 : heights[i];
//            
//            while(!stack.isEmpty() && currentHeight < heights[stack.peek()]) {
//                int height = heights[stack.pop()];
//                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
//                maxArea = Math.max(maxArea, height * width);
//            }
//            stack.push(i);
//        }
// This is the approach it suggested. 