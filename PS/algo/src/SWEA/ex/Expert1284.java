package SWEA.ex;

import java.util.Scanner;

public class Expert1284 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);

        int t= sc.nextInt();
        for(int i=0;i<t;i++){
            int P = sc.nextInt();
            int Q = sc.nextInt();
            int R = sc.nextInt();
            int S = sc.nextInt();
            int W = sc.nextInt();

            int A =W*P;
            int B =0;
            if(R>W){
                B=Q;
            }else{
                B=Q+(W-R)*S;
            }
            int answer = A>B?B:A;

            System.out.println(answer);
        }
    }
}
