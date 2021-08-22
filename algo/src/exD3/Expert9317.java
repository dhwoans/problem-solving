package exD3;

import java.util.Scanner;

public class Expert9317 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T =sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int N =sc.nextInt();
            String str = sc.next();
            String answer = sc.next();
            int count =0;
            for (int i = 0; i < N; i++) {
                if(str.charAt(i)==answer.charAt(i)){
                    count++;
                }
            }
            System.out.println("#"+test_case+" "+count);

        }
    }
}
