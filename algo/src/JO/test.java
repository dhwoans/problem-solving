package JO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test {
    static int[][] map;
    static int[][] visit;
    static int count;
    static int dir[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            int n = Integer.parseInt(br.readLine());

            map = new int[n][n];
            visit = new int[n][n];
            // 입력 받기
            int x = 0;
            int y = 0;
            for (int i = 0; i < map.length; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < map[i].length; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    visit[i][j] = Integer.MAX_VALUE;
                    if (map[i][j] == 2) {
                        x = i;
                        y = j;
                    }
                }
            }
            count = 0;
            check(1, x, y);
            for (int[] ints : visit) {
                for (int i : ints) {
                    if (i > 120) continue;
                    count++;
                }

            }

            System.out.println("#" + test_case + " " + count);

        }

    }

    //이동범위체크
    private static void check(int cnt, int x, int y) {
        if (cnt == 4) {
            return;
        }
        for (int j = 0; j < 4; j++) {
            int nx = x;
            int ny = y;

            boolean flag = false;


            while (true) {
                nx += dir[j][0];
                ny += dir[j][1];

                //범위체크
                if (nx < 0 || ny < 0 || nx >= map.length || ny >= map.length) break;

                if (flag) {

                    if (map[nx][ny] == 1 && visit[nx][ny] > cnt) {
                        visit[nx][ny] = cnt;

                        map[x][y] = 0;
                        map[nx][ny] = 2;
                        check(cnt + 1, nx, ny);
                        map[nx][ny] = 1;
                        map[x][y] = 2;
                        break;

                    } else if (map[nx][ny] == 1 && visit[nx][ny] <= cnt) {
                        break;
                    }

                    if (cnt == 3) continue;
                    map[x][y] = 0;
                    map[nx][ny] = 2;
                    check(cnt + 1, nx, ny);
                    map[nx][ny] = 0;
                    map[x][y] = 2;

                }

                if (map[nx][ny] == 1) {
                    flag = true;
                }
            }
        }

    }

}
