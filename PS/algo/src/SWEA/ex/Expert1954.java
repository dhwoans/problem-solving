package SWEA.ex;

import java.util.Scanner;

public class Expert1954 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int dir[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};//우 하 좌 상
        for (int i = 1; i <= T; i++) {
            int N = sc.nextInt();
            int arr[][] = new int[N][N];
            int r = 0;
            int c = 0;
            int x = 0;

            for (int n = 1; n <= N * N; n++) {
                arr[r][c] = n;

                int nr = r + dir[x][0];
                int nc = c + dir[x][1];

                if (nr < 0 || nc < 0 || nr >= N || nc >= N || arr[nr][nc] != 0) {
                    if (x == 3) {
                        x = 0;
                    } else {
                        x += 1;
                    }

                    r += dir[x][0];
                    c += dir[x][1];

                    continue;
                }

                r = nr;
                c = nc;
            }

            System.out.printf("#%d\n", i);
            for (int a = 0; a < N; a++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(arr[a][j] + " ");
                }
                System.out.println();


            }


        }


    }
}


