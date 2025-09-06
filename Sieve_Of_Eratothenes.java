import java.util.Arrays;
import java.util.Scanner;

public class Sieve_Of_Eratothenes {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        boolean[] isprime= new boolean[n+1];
        Arrays.fill(isprime, true);
        isprime[0]=false;
        isprime[1]=false;

        for(int i = 2; i<=n; i++){
            if(isprime[i]=true){
                for(int j = 2; j*j<=i; j++){
                    if(i%j==0){
                        isprime[i]=false;
                        break;
                    }
                }
            }
            
        }

        for(int i = 0; i<n; i++){
            if(isprime[i]==true){
                System.out.println(i);
            }
        }
    }
}
