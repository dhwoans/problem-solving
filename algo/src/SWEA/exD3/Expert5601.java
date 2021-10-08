package SWEA.exD3;

import java.util.Scanner;

public class Expert5601 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T =sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            System.out.print("#"+test_case+" ");
            for (int i = 0; i < N; i++) {
                System.out.print("1/"+N+" ");
            }

        }
    }
}
