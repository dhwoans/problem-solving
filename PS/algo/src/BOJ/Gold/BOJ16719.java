package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;


public class BOJ16719 {

    private static String str;
    private static boolean[] visited;
    private static PriorityQueue<String> que;
    private static String min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        PriorityQueue<int[]> que = new PriorityQueue<>((o1, o2) -> o1[0]);

        for (int i = 0; i < str.length(); i++) {
            que.add(new int[]{i,str.charAt(i)});
        }

        for (int i = 1; i < str.length(); i++) {

        }

    }
}
