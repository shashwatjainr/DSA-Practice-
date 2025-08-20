import java.util.Scanner;

public class PowerOf_Num_Logn {
    public static void main(String []args){
        Scanner scn = new Scanner(System.in);
        int x = scn.nextInt();
        int n = scn.nextInt();

        System.out.println(PowLog(x, n));
    }

    public static int PowLog(int x, int n){
        if(n==0){
            return 1;
        }
        int powE = PowLog(x, n/2);
        if(n%2==0){
            return powE*powE;
        }
        else{
            return x*powE*powE;
        }
    }
}
