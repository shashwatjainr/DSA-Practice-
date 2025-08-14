import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Sliding_Window_max {
    public static void main(String [] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr =  new int[n];
        int[] sli = new int[n]; 

        for(int i=0; i<n; i++){
            arr[i]= scn.nextInt();
        }

        int[] nge = new int[n];
        nge[n-1]=n;
        Stack<Integer> st = new Stack<>();
        st.push(n-1);
        for(int i= n-2; i>=0; i--){
            while(!st.isEmpty() && arr[i]>arr[st.peek()]){
                st.pop();
            }
            nge[i] = st.isEmpty() ? n : st.peek(); // Storing index of nge for using the index while calculating sliding win
            st.push(i);
        }
        
        
        int j=0;

        for(int i = 0; i <n-3; i++){
            if(i>j){
                j=i;
            }    
            int win = i+3;
            while(j<=win && nge[j]<=win){
                j=nge[j];
            }
            sli[i]=arr[j];            
        }
        System.out.println(Arrays.toString(sli));
    }
}