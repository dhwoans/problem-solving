package SWEA.exD3;

import java.util.Scanner;

public class Expert12221 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String data ="4\n" +
                "2 5\n" +
                "5 10\n" +
                "10 10\n" +
                "9 9";
        sc= new Scanner(data);
        int T =sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            System.out.printf("#%d ",test_case);
            if(n1>=10||n2>=10){
                System.out.print(-1);
            }else{
                System.out.print(n1*n2);
            }
            System.out.println();
        }
    }
}
