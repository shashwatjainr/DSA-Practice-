import java.util.Scanner;
import java.util.Arrays;
import java.util.Stack;

public class Dup_Brackets {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        
        Stack<Character> st = new Stack<Character>();
        for(int i = 0; i<str.length() ; i++){
            char ch = str.charAt(i);
            if(ch == ')'){
                if(st.peek() == '('){
                    System.out.println(true);
                    return;
                }
                else{
                    while(st.peek() !='('){
                        st.pop();
                    }
                    st.pop();
                }
            }
            else{
                st.push(ch);
            }
        }
        if(st.isEmpty() == true){
            System.out.println(false);
        }
    }
}
