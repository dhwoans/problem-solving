package exD3;

import java.util.Scanner;

public class Expert12368 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String data ="3\n" +
                "1 9\n" +
                "7 17\n" +
                "23 23";

        sc=new Scanner(data);
        int T =sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int hour=sc.nextInt();
            int after=sc.nextInt();
            int sum=hour+after;
            if(sum>=24){
                sum-=24;
            }
            System.out.println("#"+test_case+" "+sum);
        }
    }
}
