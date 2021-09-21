package ex;

import java.util.Scanner;

public class test {
    static int answer;
    // 8방 지정
    static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dy = {0, 0, -1, 1, 1, -1, -1, 1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            answer = 2;
            // 크기
            int N = sc.nextInt();
            // 데이터를 담을 배열
            char[][] area = new char[N][N];
            // 데이터 입력받기
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    area[i][j] = sc.next().charAt(0);
                }
            }
            // 각 위치를 돌면서 8방에 공원이 없는지 체크
            // 만약, 해당 위치의 8방에 공원이 없다면 가로 , 세로의 빌딩수를 카운팅
            for (int i = 0; i < N; i++) {
                outer: for (int j = 0; j < N; j++) {
                    if (area[i][j] == 'G') continue;  // 공원일 경우 스킵
                    // 해당 위치가 B라면 8방 체크 한다.
                    for (int d = 0; d < 8; d++) {
                        int nx = dx[d] + i;
                        int ny = dy[d] + j;
                        // 범위체크
                        if (nx >= N || ny >= N || nx < 0 || ny < 0) continue;
                        // 만약, 8방에 공원이 있다면 다음 위치로 이동시킨다.
                        if (area[nx][ny] == 'G') continue outer;
                    }
                    // 이 위치의 의미는 무엇?? 8방안에 공원이 없다..
                    // 가로, 세로 위치의 빌딩 숫자를 카운팅 한다.
                    int count = -1;
                    for (int k = 0; k < N; k++) {
                        if (area[i][k] == 'B') count++;
                        if (area[k][j] == 'B') count++;
                    }
                    // 기존 빌딩의 카운트와 새로운 좌표에서 구한 빌딩의 카운트 중에서 큰값을 설정
                    answer = Math.max(answer, count);
                }
            }

            System.out.println("#" + t + " " + answer);
        }
    }
}
