package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 14503.로봇 청소가
 * <p>
 * r은 북쪽으로부터 떨어진 칸의 개수, c는 서쪽으로 부터 떨어진 칸의 개수
 * <p>
 * 1.현재 위치를 청소한다.
 * 2.현재 위치에서 현재 방향을 기준으로 왼쪽 방향부터 차례대로 인접한 칸을 탐색한다.
 * a.왼쪽 방향에 아직 청소하지 않은 공간이 존재한다면, 그 방향으로 회전한 다음 한 칸을 전진하고 1번부터 진행한다.
 * b.왼쪽 방향에 청소할 공간이 없다면, 그 방향으로 회전하고 2번으로 돌아간다.
 * c.네 방향 모두 청소가 이미 되어있거나 벽인 경우에는, 바라보는 방향을 유지한 채로 한 칸 후진을 하고 2번으로 돌아간다.
 * d.네 방향 모두 청소가 이미 되어있거나 벽이면서, 뒤쪽 방향이 벽이라 후진도 할 수 없는 경우에는 작동을 멈춘다.
 */
public class BOJ14503 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];

        //청소기 정보
        //0 북, 1 동, 2 남, 3 서
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int dir = Integer.parseInt(st.nextToken());

        //맵정보
        for (int i = 0; i < map.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] del = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}}; //0 북, 1 동, 2 남, 3 서

        out:while (true) {
            boolean flag = false;
            // 현재 위치 청소
            map[r][c] = 2;

            //왼쪽 방향부터 차례대로 인접한 칸을 탐색
            if (dir == 3)dir=-1;
            for (int i = dir + 1; i < 4; i++) {
                int nr = r + del[i][0];
                int nc = c + del[i][1];

                if (nr >= 0 && nc >= 0 && nr < map.length && nc < map.length && map[nr][nc] == 0) {
                    r = nr;
                    c = nc;
                    //방향바꿈
                    if (dir == 3) {
                        dir = 0;
                    }
                    dir++;

                    break;
                } else {
                    //방향바꿈
                    if (dir == 3) {
                        dir = 0;
                    }
                    dir++;
                    flag=true;
                    continue;
                }
            }
            //다 벽이거나 청소된 구역
            if(!flag)continue ;
            if (r > 0 && c > 0 && r < map.length-1 && c < map.length-1) {

                if (dir == 0 || dir == 1) {
                    dir += 2;
                } else {
                    dir -= 2;
                }
                r = r + del[dir][0];
                c = c + del[dir][1];
            } else {
                break out;
            }

        }
        int count=0;
        for (int[] ints : map) {
            for (int i : ints) {
                if(i==2)count++;
            }
        }
        System.out.println(count);

    }
}
