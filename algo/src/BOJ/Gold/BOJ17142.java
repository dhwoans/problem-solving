package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ17142 {
    static int M, N;
    static int[][] map;
    static boolean[][] visit;
    static ArrayList<Integer[]> pos;
    static boolean[] comb;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static ArrayList<Integer> answer;
    static int count =0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        //값 입력
        map = new int[N][N];
        visit = new boolean[N][N];
        pos = new ArrayList<>();
        for (int i = 0; i < map.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    pos.add(new Integer[]{i, j});
                }
            }
        }

        //조합

        comb = new boolean[pos.size()];
        answer = new ArrayList<>();
        count=0;
        comb(0, 0);

        int val = answer.stream().max((o1, o2) -> o1-o2).orElse(123);
        if(val==-999){
            System.out.println(-1);
        }else {
            int val2 =answer.stream().filter(i -> i!=-999).min((o1, o2) -> o1-o2).orElse(234095);
        System.out.println(val2-1);
        }

    }

    private static void comb(int cnt, int start) {
        if (cnt == M) {
            bfs();

            return;
        }
        for (int i = start; i < comb.length; i++) {
            if (comb[i]) continue;
            comb[i] = true;
            comb(cnt + 1, i + 1);
            comb[i] = false;
        }
    }

    private static void bfs() {
        //map 복사
        int[][] temp = new int[map.length][map[0].length];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 1) {
                    temp[i][j] = -222;
                } else if (map[i][j] == 2) {
                    temp[i][j] = 1;
                } else if(map[i][j]==0){
                    continue;
                }
            }
        }
        //바이러스 찍기
        Queue<Integer[]> que = new LinkedList();
        for (int i = 0; i < pos.size(); i++) {
            if (comb[i]) {
                int x = pos.get(i)[0];
                int y = pos.get(i)[1];
                que.offer(new Integer[]{x, y,1});
                visit[x][y]=true;

            }
        }
        int zero =0;
        while (!que.isEmpty()) {
            Integer[] z = que.poll();

            for (int i = 0; i < 4; i++) {
                int nx = z[0] + dir[i][0];
                int ny = z[1] + dir[i][1];

                if (nx < 0 || ny < 0 || nx >= temp.length || ny >= temp.length) continue;
                if (temp[nx][ny] == 0&&!visit[nx][ny]) {
                    visit[nx][ny]=true;
                    temp[nx][ny] = temp[z[0]][z[1]] + 1;
                    que.add(new Integer[]{nx, ny,temp[nx][ny]});
                }else if (temp[nx][ny] == 1&&!visit[nx][ny]) {
                    visit[nx][ny]=true;
                    temp[nx][ny] = z[2];
                    que.add(new Integer[]{nx, ny,temp[nx][ny]});
                }



            }
        }
        boolean flag = true;
        int max = Integer.MIN_VALUE;
        out:
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp.length; j++) {
                if (temp[i][j] == 0) {
                    answer.add(-999);
                    flag = false;
                    break out;
                }
                max = Math.max(max, temp[i][j]);
            }
        }
        if (flag) {
            answer.add(max);
        }
    }
}
