package SWEA.exD3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Expert6485 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());

            int[] map = new int[5001];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                for (int j = start; j <= end; j++) {
                    map[j]++;
                }

            }
            System.out.print("#"+test_case+" ");
            int stop = Integer.parseInt(br.readLine());
            for (int i = 1; i <= stop; i++) {
                int num = Integer.parseInt(br.readLine());
                System.out.print(map[num]+" ");
            }
            System.out.println();

        }
    }
}
