package BOJ.Gold;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2206 {

    private static int r;
    private static int c;
    private static int answer;

    private static class xy {
        int x;
        int y;
        int n;
        int destroy;

        private xy(int x, int y, int n, int destroy) {
            this.x = x;
            this.y = y;
            this.n = n;
            this.destroy = destroy;
        }
    }

    private static int[][] map;
    private static boolean[][][] visited;
    private static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        answer = Integer.MAX_VALUE;

        map = new int[r][c];
        visited = new boolean[2][r][c];

        //정보입력
        for (int i = 0; i < map.length; i++) {
            String str = br.readLine();
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
        check(0, 0);
        if (answer == Integer.MAX_VALUE) {
            answer = -1;
        }
        System.out.println(answer);
    }

    private static void check(int x, int y) {
        Queue<xy> que = new LinkedList<>();
        que.add(new xy(x, y, 1, 0));
        visited[0][x][y] = true;

        while (!que.isEmpty()) {
            xy z = que.poll();

            if (z.x == r - 1 && z.y == c - 1) {
                answer = Math.min(answer, z.n);
            }

            for (int i = 0; i < 4; i++) {
                int nx = z.x + dir[i][0];
                int ny = z.y + dir[i][1];

                if (nx < 0 || ny < 0 || nx >= r || ny >= c) continue;
                //벽이면
                if (map[nx][ny] == 1 && !visited[1][nx][ny]) {
                    if(z.destroy==1)continue;
                    visited[1][nx][ny] = true;
                    que.add(new xy(nx, ny, z.n + 1, 1));
                } else if(map[nx][ny]==0&&!visited[z.destroy][nx][ny]){
                    visited[z.destroy][nx][ny] = true;
                    que.add(new xy(nx, ny, z.n + 1, z.destroy));


                }
            }
        }
    }
}
