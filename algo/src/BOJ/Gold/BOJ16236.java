package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ16236 {

    private static int sum;
    private static boolean[][] visited;
    private static int n;
    private static PriorityQueue<xy> fish;

    private static class xy {
        int x;
        int y;
        int dis;
        int count;
        int size;

        public xy(int dis) {

            this.dis = dis + 1;
        }

        public xy(int x, int y, int size) {
            this.x = x;
            this.y = y;
            this.size = size;
            count = 0;
            dis = 0;
        }

        public void eat() {
            count++;
        }

        public void level() {
            if (count == size) {
                size += 1;
                count = 0;


            }

        }
    }

    private static xy shark;

    private static int[][] map;
    private static int[][] dir = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};//상 좌 우 하

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        sum = 0;
        map = new int[n][n];

        //정보입력
        for (int i = 0; i < map.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    shark = new xy(i, j, 2);
                }
            }
        }
        search();
        while (!fish.isEmpty()) {

            if (fish.peek().dis == 100) break;
            xy value = fish.poll();
            sum += value.dis;
            shark.eat();
            //상어이동
            map[shark.x][shark.y] = 0;
            map[value.x][value.y] = 9;
            shark.x = value.x;
            shark.y = value.y;
            //커졌는지 확인
            shark.level();
            search();


        }
        System.out.println(sum);
    }

    private static int check(int x, int y) {
        visited = new boolean[n][n];
        Queue<xy> que = new LinkedList<>();
        que.add(shark);
        visited[shark.x][shark.y] = true;

        while (!que.isEmpty()) {
            xy z = que.poll();

            if (z.x == x && z.y == y) {
                return z.dis;
            }

            if (!fish.isEmpty() && fish.peek().dis < z.dis) continue;

            for (int i = 0; i < 4; i++) {
                int nx = z.x + dir[i][0];
                int ny = z.y + dir[i][1];

                if (nx < 0 || ny < 0 || nx >= map.length || ny >= map[0].length || visited[nx][ny]) continue;
                if (map[nx][ny] <= shark.size) {
                    visited[nx][ny] = true;
                    xy xy = new xy(z.dis);
                    xy.x = nx;
                    xy.y = ny;
                    que.add(xy);
                }
            }
        }
        return 100;
    }

    private static void search() {
        fish = new PriorityQueue<xy>((o1, o2) -> {
            if (o1.dis == o2.dis) {
                if (o1.x == o2.x) {
                    return o1.y - o2.y;
                } else {
                    return o1.x - o2.x;
                }
            }
            return o1.dis - o2.dis;
        });
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] != 0 && map[i][j] < shark.size) {
                    xy xy = new xy(check(i, j) - 1);
                    xy.x = i;
                    xy.y = j;
                    fish.add(xy);

                }
            }
        }
    }
}
