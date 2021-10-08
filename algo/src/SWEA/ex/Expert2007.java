package SWEA.ex;

import java.util.Scanner;

public class Expert2007 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T =sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            String str = sc.next();
            for (int i = 1; i <= str.length(); i++) {
                String a = str.substring(0,i);
                String b = str.substring(i,i+i);
                if(a.equals(b)){
                    System.out.println("#"+test_case+" "+a.length());
                    break;
                }

            }

        }

    }
}
