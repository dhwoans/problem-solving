package SWEA.exD3;

import java.util.Scanner;

public class Expert4751 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String data1 = "\n" +
                "2\n" +
                "D\n" +
                "APPLE";
        sc = new Scanner(data1);
        int T = sc.nextInt();
        for (int test_case = 0; test_case < T; test_case++) {
            StringBuilder sb = new StringBuilder();
            String data = sc.next();
            char[] chars = new char[data.length()];
            for (int i = 0; i < data.length(); i++) {
                chars[i] = data.charAt(i);
            }
            for (int i = 0; i < chars.length; i++) {
                if (chars.length == 1) {
                    System.out.println("..#..\n.#.#.\n#.D.#\n.#.#.\n..#..");
                } else {

                    String a1 = "";
                    if (i % 2 == 1) {
                        a1 = ".#.";

                    } else {
                        a1 = "..#..";
                    }
                    sb.append(".#.");

                    System.out.print(a1);



                }
            }
            
        }
    }
}
