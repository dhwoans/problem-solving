package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 2636.치즈
 * <p>
 * BFS를 사용
 * <p>
 * 안쪽 공기 바깥 공기 구별
 */
public class BOJ2636 {
    static int r, c;
    static int[][] map;
    static boolean[][] visit;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        //배열 값 넣기
        map = new int[r][c];
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //bfs
        int max = Integer.MAX_VALUE;
        int day = 0;
        int count = 0;
        while (true) {
            day++;

            out:
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[i].length; j++) {
                    if (map[i][j] == 0) {
                        bfs(i, j);
                        break out;
                    }

                }
            }
            //c없애기
            count = 0;
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[i].length; j++) {
                    if (map[i][j] == 2) {
                        map[i][j] = 0;
                    }
                    if (map[i][j] == 3) {
                        count++;
                        map[i][j] = 0;
                    }
                }
            }

            //치즈 개수 저장
            if (count != 0 && max > count) {
                max = count;
            } else if (count == 0) {
                break;
            }

        }
        System.out.println(day - 1);
        System.out.println(max);
    }

    private static void bfs(int x, int y) {
        Queue<Integer[]> q = new LinkedList<>();
        q.offer(new Integer[]{x, y});
        map[x][y] = 2;
        while (!q.isEmpty()) {
            Integer[] xy = q.poll();


            for (int i = 0; i < 4; i++) {
                int nr = xy[0] + dir[i][0];
                int nc = xy[1] + dir[i][1];

                if (nr < 0 || nc < 0 || nr >= r || nc >= c) continue;
                if (map[nr][nc] == 0) {
                    map[nr][nc] = 2;
                    q.offer(new Integer[]{nr, nc});
                }
                if (map[nr][nc] == 1) {
                    map[nr][nc] = 3;
                }


            }

        }
    }
}
