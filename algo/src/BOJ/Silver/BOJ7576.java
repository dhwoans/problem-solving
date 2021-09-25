package BOJ.Silver;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ7576 {
    static int r, c;
    static int[][] map;
    static boolean[][] visit;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static Queue<node> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new int[c][r];
        visit = new boolean[c][r];
        q = new LinkedList<>();
        //배열담기
        for (int i = 0; i < c; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < r; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    q.offer(new node(i, j));
                    visit[i][j] = true;
                }
            }
        }
        BFS();
        //상태 확인
        int answer = Integer.MIN_VALUE;
        out:
        for (int[] ints : map) {
            for (int a : ints) {
                if (a == 0) {
                    answer = -1;
                    break out;
                }
                answer = Math.max(a - 1, answer);
            }
        }
        if (answer == 1) {
            answer = 0;
        }
        System.out.println(answer);

    }

    static void BFS() {
        while (!q.isEmpty()) {
            node z = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = z.x + dir[i][0];
                int ny = z.y + dir[i][1];

                if (nx < 0 || ny < 0 || nx >= c || ny >= r) continue;
                if (map[nx][ny] == 0 && !visit[nx][ny]) {
                    visit[nx][ny] = true;
                    map[nx][ny] = map[z.x][z.y] + 1;
                    q.offer(new node(nx, ny));
                }

            }
        }
    }
}

class node {
    int x;
    int y;

    node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}