import java.util.Arrays;
import java.util.Stack;
import java.util.Scanner;


public class Infix_Conversion {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        String exp= scn.nextLine();

        Stack<String> pre = new Stack<>();
        Stack<String> pos = new Stack<>();
        Stack<Character> op = new Stack<>();
        
        for(int i = 0; i<exp.length(); i++){
            char opt = exp.charAt(i);
            if((opt >= '0' && opt <= '9') || (opt >= 'a' && opt <= 'z') || (opt >= 'A' && opt <= 'Z')){
                pre.push(opt + "");
                pos.push(opt + "");
            }
            else if(opt == '('){
                op.push(opt);
            }
            else if(opt == ')'){
                while(!op.isEmpty() && op.peek() != '('){
                    char opr = op.pop();

                    String a2 = pre.pop();
                    String a1 = pre.pop();
                    String prex = opr + a1 + a2; 
                    pre.push(prex);

                    String b2 = pos.pop();
                    String b1 = pos.pop();
                    String posx = b1 + b2 + opr;                    
                    pos.push(posx);
                }
                op.pop();
            }
            else if(opt == '/' || opt == '*' || opt == '+' || opt == '-'){
                while(!op.isEmpty() && op.peek() != '(' && precedence(opt) <= precedence(op.peek())){
                    char opr = op.pop();

                    String a2 = pre.pop();
                    String a1 = pre.pop();
                    String prex = opr + a1 + a2; 
                    pre.push(prex);

                    String b2 = pos.pop();
                    String b1 = pos.pop();
                    String posx = b1 + b2 + opr;                    
                    pos.push(posx);
                }
                op.push(opt);
            }   
        }

        while(!op.isEmpty()){
            char opr = op.pop();

            String a2 = pre.pop();
            String a1 = pre.pop();
            String prex = opr + a1 + a2;
            pre.push(prex);

            String b2 = pos.pop();
            String b1 = pos.pop();
            String posx = b1 + b2 + opr;                    
            pos.push(posx);        
        }

        System.out.println(pre.pop());
        System.out.println(pos.pop());
    }

    public static int precedence(char op){
        if(op == '/' || op == '*'){
            return 2;
        }
        else if(op == '+' || op == '-'){
            return 1;
        }
        else{return 0;}
    }
}

