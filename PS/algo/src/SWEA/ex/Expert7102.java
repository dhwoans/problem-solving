package SWEA.ex;

import java.util.Scanner;

public class Expert7102 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String data ="\n" +
                "2\n" +
                "6 6\n" +
                "6 4";

        sc=new Scanner(data);
        int T =sc.nextInt();
        for (int test_case = 0; test_case < T; test_case++) {
            int max =Integer.MIN_VALUE;
            int n=sc.nextInt();
            int m=sc.nextInt();

            int arr[]=new int[n+m+1];

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    arr[i+j]++;
                }
            }
            for (int i = 0; i < arr.length; i++) {
                max=Math.max(max,arr[i]);

            }
            System.out.println(max);
        }
    }
}
