import java.util.Scanner;

public class Tower_Of_Hanoi {
    public static void main(String [] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int t1 = scn.nextInt();
        int t2 = scn.nextInt();
        int t3 = scn.nextInt();

        TOH(n,t1, t2, t3);

    }

    public static void TOH(int n, int tid1, int tid2, int tid3){
        if(n==0){return;}
        TOH(n-1, tid1, tid3, tid2);
        System.out.println(n + "[" + tid1 + " -> " + tid2 + "]");
        TOH(n-1, tid3, tid2, tid1);        
    }
}
