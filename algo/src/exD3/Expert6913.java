package exD3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Expert6913 {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("algo/src/input/input6913.txt"));
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int map[][] = new int[N][M];
            int count = 0;
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    map[i][j]=sc.nextInt();
                    if (map[i][j] == 1) count++;
                }
                max=Math.max(max,count);
                count=0;

            }
            int person = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(map[i][j]==1) count++;
                }
                if(max == count) person++;
            }
            System.out.println("#"+test_case+" "+person+" "+max);

        }
    }
}
