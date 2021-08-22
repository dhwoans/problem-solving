package exD3;

import java.util.Scanner;

public class Expert8673 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String data = "2\n" +
                "2\n" +
                "7 1 4 3\n" +
                "3\n" +
                "31 46 13 29 27 45 10 57";
        sc= new Scanner(data);
        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int k = sc.nextInt();
            int length = (int) (Math.pow(2, k + 1) - 1);
            int[] ints = new int[length];


            //배열에 담기
            int round1 =(int)(Math.pow(2,k));
            for (int i = 0; i < round1; i++) {
                ints[i] = sc.nextInt();
            }

            int start =(int)(Math.pow(2,k));
            int sum = 0;
            for (int i = 0; i < length -1; i+=2) {
                ints[start+(i/2)]=Math.max(ints[i],ints[i+1]);
                sum+=Math.abs(ints[i]-ints[i+1]);
            }

            System.out.println("#"+test_case+" "+sum);
        }
    }
}

