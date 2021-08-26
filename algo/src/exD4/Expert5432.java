package exD4;


import java.util.Scanner;


public class Expert5432 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        String data =
//                "2\n" +
//                        "()(((()())(())()))(())\n" +
//                        "(((()(()()))(())()))(()())";
//        sc = new Scanner(data);
        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            String str = sc.next();
            str = str.replace("()", "0");

            int count = 0;
            int open = 0;

            for (int i = 0; i < str.length(); i++) {
                char z=str.charAt(i);
                if (z == '(') {
                   open++;
                } else if (z == ')') {
                    count++;
                    open--;
                } else {
                    count+=open;
                }

            }

            System.out.println("#" + test_case + " " + count);
        }
    }
}

