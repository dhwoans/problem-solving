package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @packageName : BOJ.Gold
 * @fileName : BOJ2638
 * @date : 2022-02-03
 * @language : JAVA
 * @classification :
 * @time_limit : 2sec
 * @required_time : 00:40 ~ 01:22
 * @submissions : 1
 * @description :
 **/
public class BOJ2638 {
    static class xy {
        int x;
        int y;

        xy(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int r, c;
    static int[][] map;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new int[r][c];

        for (int i = 0; i < map.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < map[0].length; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int count = 0;
        while (true) {
        boolean flag = true;
            count++;
            Bfs();
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[0].length; j++) {
                    if (map[i][j] >= 3) {
                        map[i][j] = 0;
                    } else if (map[i][j] == 2) {
                        map[i][j] = 1;
                    }
                }
            }
            out:
            for (int[] i : map) {
                for (int z : i) {
                    if (z != 0) {
                        flag = false;
                        break out;
                    }
                }
            }
            if (flag) {
                break;
            }

        }
        System.out.println(count);

    }

    private static void Bfs() {
        Queue<xy> que = new LinkedList<>();
        que.add(new xy(0, 0));
        map[0][0] = 5;
        while (!que.isEmpty()) {
            xy temp = que.poll();

            for (int i = 0; i < 4; i++) {
                int nx = temp.x + dir[i][0];
                int ny = temp.y + dir[i][1];

                if (nx < 0 || ny < 0 || nx >= r || ny >= c) continue;
                if (map[nx][ny] == 0) {
                    que.add(new xy(nx, ny));
                    map[nx][ny] = 5;
                } else {
                    map[nx][ny] += 1;
                }

            }
        }
    }
}
