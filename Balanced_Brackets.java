import java.util.Scanner;
import java.util.Stack;


public class Balanced_Brackets {
    public static void main(String [] args){
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();

        Stack<Character> st = new Stack<Character>();
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);

            if(ch == ')'){
                if(st.isEmpty() == true){
                    System.out.println(false);
                    return;
                } 
                if(st.peek() == '('){
                    st.pop();
                }
                else{
                    System.out.println(false);
                    return;
                }
            }
            if(ch == ']'){
                if(st.isEmpty() == true){
                    System.out.println(false);
                    return;
                } 
                if(st.peek() == '['){
                    st.pop();
                }
                else{
                    System.out.println(false);
                    return;
                }
            }
            if(ch == '}'){
                if(st.isEmpty() == true){
                    System.out.println(false);
                    return;
                } 
                if(st.peek() == '{'){
                    st.pop();
                }
                else{
                    System.out.println(false);
                    return;
                }
            }
            if(ch == '(' || ch == '[' || ch == '{'){
                st.push(ch);
            }
            
        }
        System.out.println(st.isEmpty());
    }
}
