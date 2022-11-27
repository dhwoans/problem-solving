package SWEA.exD4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1953.탈주범 검거
 * <p>
 * 그래프 탐색 문제
 * <p>
 * 2차원 배열 간선정보가 따로 주어짐
 * <p>
 * bfs로 탐색 -> 파이프가 이어져 있는지 체크
 */
public class Expert1953 {
    static int N, M, R, C, L;
    static int[][] map, time;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            //배열 담기
            map = new int[N][M];
            for (int i = 0; i < map.length; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < map[i].length; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            bfs();
            int count = 0;
            for (int[] ints : time) {
                for (int a : ints) {
                    if (a!=0&&a <= L){
                        count++;}
                }
            }
            System.out.println("#" + test_case + " " + count);

        }
    }


    private static void bfs() {
        time = new int[N][M];
        Queue<pipe> q = new LinkedList<>();
        q.offer(new pipe(R, C));
        time[R][C] = 1;
        while (!q.isEmpty()) {
            pipe z = q.poll();


            for (int i = 0; i < 4; i++) {
                int nr = z.x + dir[i][0];
                int nc = z.y + dir[i][1];
                //파이프 모양에 따라 퍼지는 방향이 다르다
                // 상 0 하 1 좌 2 우 3
                switch (map[z.x][z.y]) {
                    case 2:
                        if (i == 2 || i == 3) {
                            continue;
                        }
                        break;
                    case 3:
                        if (i == 0 || i == 1) {
                            continue;
                        }
                        break;
                    case 4:
                        if (i == 1 || i == 2) {
                            continue;
                        }
                        break;
                    case 5:
                        if (i == 0 || i == 2) {
                            continue;
                        }
                        break;
                    case 6:
                        if (i == 0 || i == 3) {
                            continue;
                        }
                        break;
                    case 7:
                        if (i == 1 || i == 3) {
                            continue;
                        }
                        break;
                }
                //범위체크
                if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
                //방문체크,파이프 이어져 있는지 체크,파이프 유무 체크
                if (time[nr][nc] == 0&&check(nr,nc,i)&&map[nr][nc]!=0) {
                    time[nr][nc] = time[z.x][z.y] + 1;
                    q.offer(new pipe(nr, nc));
                }
            }

        }
    }
    //방향에 따라 이어지는 파이프 모양이 다르다
    static boolean check(int nr, int nc, int dir) {
        switch (dir) {
            case 0:
                if (map[nr][nc] == 3 || map[nr][nc] == 4 || map[nr][nc] == 7) {
                    return false;
                } else {
                    return true;
                }
            case 1:
                if (map[nr][nc] == 3 || map[nr][nc] == 5 || map[nr][nc] == 6) {

                    return false;
                } else {
                    return true;
                }
            case 2:
                if (map[nr][nc] == 2 || map[nr][nc] == 6 || map[nr][nc] == 7) {
                    return false;
                } else {
                    return true;
                }
            case 3:
                if (map[nr][nc] == 2 || map[nr][nc] == 4 || map[nr][nc] == 5) {
                    return false;
                } else {
                    return true;
                }
        }
        return false;
    }

    static class pipe {
        int x;
        int y;


        pipe(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

