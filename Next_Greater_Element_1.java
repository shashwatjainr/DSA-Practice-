import java.util.Scanner;
import java.util.Stack;
import java.util.Arrays;

public class Next_Greater_Element_1{
    public static void main(String [] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        int[] nge = new int[n];
        for(int i = 0; i<n; i++){
            arr[i]=scn.nextInt();
        }
        Stack<Integer> st = new Stack<>();
        st.push(arr[n-1]);
        nge[n-1] = -1;
        for(int i = n-2; i>=0; i--){
            while(!st.isEmpty() && arr[i]>st.peek()){
                st.pop();
            }
            if(st.isEmpty()){
                nge[i] = -1;
            }
            else{
                nge[i]=st.peek();
            }
            st.push(arr[i]);
        }
        System.out.println(Arrays.toString(nge));
    }     
}