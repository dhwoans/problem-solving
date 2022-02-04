package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @packageName : BOJ.Silver
 * @fileName : BOJ7562
 * @date : 2022-02-03
 * @language : JAVA
 * @classification :
 * @time_limit : 2sec
 * @required_time : 00:40 ~ 01:22
 * @submissions : 1
 * @description :
 **/
public class BOJ7562 {
    static class xy {
        int x;
        int y;
        int count;

        xy(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    static int l, answer;
    static int[][] map;
    static int[][] visit;
    static int[][] dir = {{-2, -1}, {-2, 1}, {1, -2}, {-1, -2}, {2, -1}, {2, 1}, {-1, 2}, {1, 2}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            l = Integer.parseInt(br.readLine());
            map = new int[l][l];
            visit = new int[l][l];
            StringTokenizer st = new StringTokenizer(br.readLine());
            xy pos = new xy(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);
            st = new StringTokenizer(br.readLine());
            xy target = new xy(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);
            answer = Integer.MAX_VALUE;

            for (int j = 0; j < visit.length; j++) {
                for (int k = 0; k < visit.length; k++) {
                    visit[j][k]=987654321;
                }
            }

            bfs(pos, target);
            System.out.println(answer);
        }
    }

    private static void bfs(xy pos, xy target) {
        Queue<xy> que = new LinkedList<>();
        que.add(pos);
        visit[pos.x][pos.y]=0;

        while (!que.isEmpty()) {
            xy temp = que.poll();
            if (target.x == temp.x && target.y == temp.y) {
                answer = Math.min(answer, temp.count);
            }

            for (int i = 0; i < 8; i++) {
                int nx = temp.x + dir[i][0];
                int ny = temp.y + dir[i][1];

                if (nx < 0 || ny < 0 || nx >= l || ny >= l) continue;
                if (visit[nx][ny] > temp.count) {
                    visit[nx][ny]=temp.count;
                    que.add(new xy(nx, ny, temp.count + 1));
                }
            }
        }
    }
}
