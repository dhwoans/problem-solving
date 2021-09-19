package ex;

import java.util.Scanner;

public class Expert1989 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int j=1;j<=t;j++) {
            String q = sc.next();
            char[] ch = new char[q.length()];
            int answer = 0;
            for (int i = 0; i < ch.length; i++) {
                ch[i] = q.charAt(i);
            }
            for (int z = 0; z < ch.length; z++) {
                if (ch[z] != ch[ch.length - 1 - z]) {
                    answer = 0;
                    break;
                } else {
                    answer = 1;
                }
            }
            System.out.printf("#%d %d\n", j, answer);
        }
    }
}

