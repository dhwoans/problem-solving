package SWEA.exD3;

import java.util.Scanner;


public class Expert3456 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 1; i <= T; i++) {

            int N1 = sc.nextInt();
            int N2 = sc.nextInt();
            int N3 = sc.nextInt();
            int area=0;
            int answer=0;
            if(N1==N2){
                area =N1*N3;
                answer = area/N2;
            }else{
                area=N1*N2;
                answer = area/N3;
            }
            System.out.println("#"+i+" "+answer);
        }
    }
}

