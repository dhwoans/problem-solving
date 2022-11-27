package SWEA.exD3;

import java.util.Scanner;

public class Expert9997 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String data =
                "6\n" +
                "0\n" +
                "1\n" +
                "10\n" +
                "11\n" +
                "111\n" +
                "359";
        sc=new Scanner(data);

        int T =sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int angle = sc.nextInt();
            int hour = angle/30;
            int min= (angle%30)*2;

            System.out.printf("#%d %d %d\n",test_case,hour,min);

        }
    }
}
