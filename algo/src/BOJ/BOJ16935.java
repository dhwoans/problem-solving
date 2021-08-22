package BOJ;

import java.util.Scanner;

public class BOJ16935 {
    static int N, M, R, type;
    static int[][] arr;
    static int[][] arrcopy;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        R = sc.nextInt();

        arr = new int[N][M];

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                arr[r][c] = sc.nextInt();
            }
        }
        for(int i = 0; i < R; i++) {
            type = sc.nextInt();
            switch(type){
                case 1:
                    no1();
                    break;
                case 2:
                    no2();
                    break;
                case 3:
                    no3();
                    break;
                case 4:
                    no4();
                    break;
                case 5:
                    no5();
                    break;
                case 6:
                    no6();
                    break;
            }
            N = arrcopy.length;
            M = arrcopy[0].length;
            arr = new int[N][M];
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < M; c++) {
                    arr[r][c] = arrcopy[r][c];
                }
            }
        }
        print();
    }
    static void no1() {
        arrcopy = new int[N][M];
        for (int r = 0; r < N; r++) {
            for(int c = 0; c < M; c++) {
                arrcopy[r][c] = arr[N-1-r][c];
            }
        }
    }
    static void no2() {
        arrcopy = new int[N][M];
        for (int r = 0; r < N; r++) {
            for(int c = 0; c < M; c++) {
                arrcopy[r][c] = arr[r][M-1-c];
            }
        }
    }
    static void no3() {
        arrcopy = new int[M][N];
        for (int r = 0; r < M; r++) {
            for(int c = 0; c < N; c++) {
                arrcopy[r][c] = arr[N-c-1][r];
            }
        }
    }
    static void no4() {
        arrcopy = new int[M][N];
        for (int r = 0; r < M; r++) {
            for(int c = 0; c < N; c++) {
                arrcopy[r][c] = arr[c][M-r-1];
            }
        }
    }
    static void no5() {
        arrcopy = new int[N][M];
        for (int r = 0; r < N/2; r++) {
            for(int c = 0; c < M/2; c++) {
                arrcopy[r][c] = arr[r+N/2][c];
            }
        }
        for (int r = 0; r < N/2; r++) {
            for(int c = M/2; c < M; c++) {
                arrcopy[r][c] = arr[r][c-M/2];
            }
        }
        for (int r = N/2; r < N; r++) {
            for(int c = 0; c < M/2; c++) {
                arrcopy[r][c] = arr[r][c+M/2];
            }
        }
        for (int r = N/2; r < N; r++) {
            for(int c = M/2; c < M; c++) {
                arrcopy[r][c] = arr[r-N/2][c];
            }
        }
    }
    static void no6() {
        arrcopy = new int[N][M];
        for (int r = 0; r < N/2; r++) {
            for(int c = 0; c < M/2; c++) {
                arrcopy[r][c] = arr[r][c+M/2];
            }
        }
        for (int r = 0; r < N/2; r++) {
            for(int c = M/2; c < M; c++) {
                arrcopy[r][c] = arr[r+N/2][c];
            }
        }
        for (int r = N/2; r < N; r++) {
            for(int c = 0; c < M/2; c++) {
                arrcopy[r][c] = arr[r-N/2][c];
            }
        }
        for (int r = N/2; r < N; r++) {
            for(int c = M/2; c < M; c++) {
                arrcopy[r][c] = arr[r][c-M/2];
            }
        }
    }
    static void print() {

        for(int i =0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}
