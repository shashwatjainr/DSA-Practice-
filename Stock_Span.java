import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Stock_Span {
    public static void main(String [] args)
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        int[] span= new int[n];
        int i= 0;
        for( i=0; i<n; i++){
            arr[i] = scn.nextInt();
        }

        Stack<Integer> st = new Stack<>();
        st.push(0);
        span[0] = 1;
        for(int j = 1; j<n; j++)
        {
            while(!st.isEmpty() && arr[st.peek()]<arr[j]){
                st.pop();
            }
            span[j] = st.isEmpty() ? j+1 : j-st.peek();
            st.push(j);
        }
        System.out.println(Arrays.toString(span));
    }
}