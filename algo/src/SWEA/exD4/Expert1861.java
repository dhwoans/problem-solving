package SWEA.exD4;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Expert1861 {
    static int dir[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};//상 하 좌 우
    static int arr[][];
    static int count=1;

    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int answer = 0;
            int a= Integer.MAX_VALUE;
            int size = sc.nextInt();
            arr = new int[size][size];
            //배열담기
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            //탐색
            for (int r = 0; r < arr.length; r++) {
                for (int c = 0; c < arr.length; c++) {

                    for (int d = 0; d < 4; d++) {
                        int nr = r + dir[d][0];
                        int nc = c + dir[d][1];

                        //범위에 벗어남
                        if (nr < 0 || nc < 0 || nr >= arr.length || nc >= arr.length) continue;

                        //1보다 크면 이동
                        if (arr[nr][nc] - arr[r][c] == 1) {
                                move(nr,nc);
                            if(count==answer&&a>arr[r][c]){
                                answer=count;
                                a=arr[r][c];
                            }
                            if(count>answer){
                                answer=count;
                                a=arr[r][c];
                            }

                            count=1;
                        }

                    }
                }
            }
            System.out.printf("#%d %d %d",test_case,a,answer);
            System.out.println();
        }

    }

    static void move(int r, int c) {
        count++;
        int nr=0;
        int nc=0;
        for (int d = 0; d < 4; d++) {
            nr = r + dir[d][0];
            nc = c + dir[d][1];

            if (nr < 0 || nc < 0 || nr >= arr.length || nc >= arr.length) continue;

            if (arr[nr][nc] - arr[r][c] == 1) {
                move(nr, nc);
            }



        }

    }
}