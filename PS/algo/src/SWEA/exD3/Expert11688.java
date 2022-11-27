package SWEA.exD3;

import java.util.Scanner;

public class Expert11688 {
    static int a,b;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            a=1;
            b=1;
            String commend =sc.next();
            char input[] =new char[commend.length()];
            for (int i = 0; i < commend.length(); i++) {
                input[i]=commend.charAt(i);
            }
            for (char c : input) {
                if(c=='L'){
                    b=a+b;
                }else{
                    a=a+b;
                }
            }
            System.out.println("#"+test_case+" "+a+" "+b);
        }
    }

}
