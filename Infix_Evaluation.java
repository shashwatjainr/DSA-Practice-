import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Infix_Evaluation {
    public static void main(String []args){
        Scanner scn = new Scanner(System.in);
        
        String exp = scn.nextLine();
        Stack<Integer> num = new Stack<>();
        Stack<Character> st = new Stack<>();
        for(int i = 0; i<exp.length(); i++){
            int a = 0;
            int b = 0;
            char element = exp.charAt(i);
            if(Character.isDigit(element)){
                num.push(Character.getNumericValue(element));
            }
            else if(element == ')'){
                while(st.peek() != '('){
                    a=num.pop();
                    b=num.pop();
                    char optor = st.pop();
                    
                    int oper = operation(a, b, optor);
                    num.push(oper);
                }
                st.pop();
            }
            else if(element == '/' || element == '+' || element == '-' || element == '*'){
                while(!st.isEmpty() && st.peek() != '(' && precedence(element) <= precedence(st.peek())){
                    a=num.pop();
                    b=num.pop();
                    char optor = st.pop();
                    
                    int oper = operation(a, b, optor);
                    num.push(oper);
                }
                st.push(element);
            }else if(element=='('){
                st.push(element);
            }
        }
        while(!st.isEmpty()){
            int a = num.pop();
            int b = num.pop();
            char optor = st.pop();

            int oper = operation(a, b, optor);
            num.push(oper);
        }
        System.out.println(num.peek());
    }    

    public static int precedence(char optor){
            if(optor == '+'){
                return 1;
            }
            else if(optor == '-'){
                return 1;
            }
            else if(optor == '*'){
                return 2;
            }
            else if(optor == '/'){
                return 2;
            }
            return 0;
    }

    public static int operation(int v1, int v2, char optor){
        if(optor == '*'){ return v1*v2;}
        else if(optor == '+'){ return v1+v2;}
        else if(optor == '/'){ return v2/v1;}
        else if(optor == '-'){ return v2-v1;}
        return 0;
    }
}

