package SWEA.ex;

import java.util.Scanner;

public class Expert3431 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int test_case=0;test_case<T;test_case++){
            int L=sc.nextInt();
            int U=sc.nextInt();
            int X=sc.nextInt();
            int answer = 0;
            if(X>U){
                answer =-1;
            }else if(X>L&&X<U){
                answer = 0;
            }else if(X<L){
                answer = L-X;
            }
            System.out.println("#"+test_case+""+answer);
        }
    }
}
