package BOJ;

import java.util.Scanner;

/**
 * 첫째 줄에 사무실의 세로 크기 N과 가로 크기 M이 주어진다. (1 ≤ N, M ≤ 8)
 * <p>
 * 둘째 줄부터 N개의 줄에는 사무실 각 칸의 정보가 주어진다. 0은 빈 칸, 6은 벽, 1~5는 CCTV를 나타내고, 문제에서 설명한 CCTV의 종류이다.
 * <p>
 * CCTV의 최대 개수는 8개를 넘지 않는다.
 */
public class BOJ15683 {//풀이중
    static int map[][];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        //배열에 담기
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
            }
        }


        //감시카메라찾기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1 || map[i][j] == 2 || map[i][j] == 3 || map[i][j] == 4 || map[i][j] == 5) {
                    //범위체크하기
                    int left = search(i, 0, j, 1);//좌범위
                    int light = search(i, j, M, 1);//우범위
                    int up = search(j, 0, i, 0);//상범위
                    int down = search(j, i, N, 0);//아래범위
                    //범위가큰거선택
                    switch (map[i][j]) {
                        case 1:

                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                        case 5:
                            break;
                    }
                }
            }
        }


        //0체크
    }

    static int search(int i, int start, int end, int dir) {
        int count = 0;
        if (dir == 1) {
            for (int k = start; k < end; k++) {
                if (map[i][k] == 0) {
                    count++;
                }
                if (map[i][k] == 6) {
                    break;
                }
            }


        }else if(dir==0){
            for (int k = start; k < end; k++) {
                if (map[k][i] == 0) {
                    count++;
                }
                if (map[k][i] == 6) {
                    break;
                }
            }
        }
        return count;
    }
}