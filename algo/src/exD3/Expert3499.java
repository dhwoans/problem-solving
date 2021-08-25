package exD3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Expert3499 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String data = "3\n" +
                "6\n" +
                "A B C D E F\n" +
                "4\n" +
                "JACK QUEEN KING ACE\n" +
                "5\n" +
                "ALAKIR ALEXSTRASZA DR-BOOM LORD-JARAXXUS AVIANA";
        sc = new Scanner(data);
        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            //섞기
            int size = sc.nextInt();
            Queue<String> deck1 = new LinkedList<>();
            Queue<String> deck2 = new LinkedList<>();
            for (int i = 0; i < size / 2; i++) {
                deck1.offer(sc.next());
            }
            if (size % 2 == 1) {
                deck1.offer(sc.next());
            }
            for (int i = 0; i < size / 2; i++) {
                deck2.offer(sc.next());
            }


            //출력
            System.out.print("#" + test_case + " ");
            while (!deck2.isEmpty()) {
                System.out.print(deck1.poll() + " ");
                System.out.print(deck2.poll() + " ");
            }
            if (size % 2 == 1) {
                System.out.print(deck1.poll());
            }
            System.out.println();

        }

    }
}
