package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 2589.보물섬
 * <p>
 * dfs
 */
public class BOJ2589 {
    static int n;
    static int m;
    static char[][] map;
    static boolean[][] visited;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static ArrayList<xxyy> arr;
    static boolean[] check;
    static int max;
    static int[] xy;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        visited = new boolean[n][m];
        arr = new ArrayList<>();
        for (int i = 0; i < map.length; i++) {
            String str = br.readLine();
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == 'L') {
                    arr.add(new xxyy(i, j));
                }
            }
        }
        max = Integer.MIN_VALUE;
        check = new boolean[arr.size()];
        xy=new int[2];

        int[] dep = new int[2];
        Pick(0, 0);
        System.out.println(max);
    }

    private static void Pick(int cnt, int start) {
        if (cnt == 2) {
            bfs();
            return;
        }
        for (int i = start; i < check.length; i++) {
            if (check[i]) continue;
            check[i] = true;
            xy[cnt] = i;
            Pick(cnt + 1, i + 1);
            check[i] = false;

        }
    }

    private static void bfs() {
        Queue<int[]> que = new LinkedList<>();
        int value=1;
        que.add(new int[]{arr.get(xy[0]).x, arr.get(xy[0]).y,value});
        visited[arr.get(xy[0]).x][arr.get(xy[0]).y] = true;
        int toX = arr.get(xy[1]).x;
        int toY = arr.get(xy[1]).y;
        while (!que.isEmpty()) {
            int[] z = que.poll();

            if (toX == arr.get(xy[1]).x && toY == arr.get(xy[1]).y) {

                max = Math.max(z[2], max);
            }
            for (int i = 0; i < 4; i++) {
                int nx = z[0] + dir[i][0];
                int ny = z[1] + dir[i][1];

                //범위체크
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if(visited[nx][ny])continue;
                if (map[nx][ny] == 'L') {
                    visited[nx][ny] = true;
                    que.add(new int[]{nx, ny,z[2]+1});
                }
            }
        }

    }

}

class xxyy {
    int x;
    int y;

    xxyy(int x, int y) {
        this.x = x;
        this.y = y;
    }
}