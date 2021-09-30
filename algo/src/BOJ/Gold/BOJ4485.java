package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 4485.녹색 옷 입은 애가 젤다지?
 *
 * 다익스트라 문제
 *
 * 2차원 배열
 */
public class BOJ4485 {
    static int n;
    static int[][] map;
    static int visit[][];
    static PriorityQueue<xy> pq;
    static int dir[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상 하 좌 우

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 1;
        while (true) {
            String str = br.readLine();
            if (str.equals("0")) {
                break;
            }

            n = Integer.parseInt(str);
            map = new int[n][n];
            visit = new int[n][n];

            for (int i = 0; i < map.length; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < map.length; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    visit[i][j]=Integer.MAX_VALUE;
                }
            }
            dij();
            System.out.println("Problem" + " " + T + ": " + visit[n-1][n-1]);
            T++;
        }
    }

    private static void dij() {
        pq = new PriorityQueue();


        pq.add(new xy(0, 0, map[0][0]));
        visit[0][0]=map[0][0];
        while (!pq.isEmpty()) {
            xy z = pq.poll();

            if(visit[z.x][z.y]<z.value)continue;

            for (int i = 0; i < 4; i++) {
                int nx = z.x + dir[i][0];
                int ny = z.y + dir[i][1];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if(visit[nx][ny]>map[nx][ny]+visit[z.x][z.y]){
                    visit[nx][ny]=map[nx][ny]+visit[z.x][z.y];
                    pq.add(new xy(nx, ny,map[nx][ny]));
                }
            }

        }

    }
}

class xy implements Comparable<xy> {
    int x;
    int y;
    int value;

    xy(int x, int y, int value) {
        this.x = x;
        this.y = y;
        this.value = value;
    }

    @Override
    public int compareTo(xy o) {

        return this.value > o.value ? 1 : -1;
    }
}
