import java.util.Scanner;

public class Zig_Zag {
    public static void main(String []args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        pzz(n);
    }   
    
    public static void pzz(int n){
        if(n == 0){
            return;
        }
        System.out.println("Pre " + n); // pre or left part of the tree
        pzz(n-1); // calling of function part
        System.out.println("In " + n); // in part of the tree
        pzz(n-1); // calling part of the tree
        System.out.println("Post " + n); // Post or right part of the tree
    }

}

