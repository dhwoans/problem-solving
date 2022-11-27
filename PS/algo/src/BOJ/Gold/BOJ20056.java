package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ20056 {

    private static List<fire> fires;
    private static int[][] map;

    private static class fire {
        int r;
        int c;
        int m;
        int s;
        int d;

        private fire(int r, int c, int m, int s, int d) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }

    private static int[][] dir = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        fires = new ArrayList<>();

        //불 정보 저장
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            fires.add(new fire(r, c, m, s, d));
        }
        //이동명령
        for (int i = 0; i < K; i++) {
            // 맵 만들기
            map = new int[N + 2][N + 2];
            for (fire temp : fires) {
                for (int k = 0; k < temp.s; k++) {
                    temp.r += dir[temp.d][0];
                    temp.c += dir[temp.d][1];

                    if (temp.r == 0) temp.r = N;
                    else if (temp.r == N + 1) temp.r = 1;
                    if (temp.c == 0) temp.c = N;
                    else if (temp.c == N + 1) temp.c = 1;
                }
                //좌표 표시
                map[temp.r][temp.c]++;
            }
            //2개 이상 확인
            for (int j = 1; j < map.length-1; j++) {
                for (int k = 1; k < map[j].length-1; k++) {
                    if (map[j][k] >= 2) {
                        sum(j, k);
                    }
                }
            }
        }
        //질량구하기
        int answer = 0;
        for (fire fire : fires) {
            answer += fire.m;
        }
        System.out.println(answer);
    }

    private static void sum(int i, int j) {
        int sumM = 0;
        int sumS = 0;
        int d =1;
        int[][] dir = {{0,2,4,6},{1,3,5,7}};
        ArrayList<Integer> list = new ArrayList<>();
        for (int k = 0; k < fires.size(); k++) {
            fire temp = fires.get(k);
            if (temp.r == i && temp.c == j) {
                sumM += temp.m;
                sumS += temp.s;
                if (temp.d % 2 == 0) {
                    list.add(temp.d);
                }
                fires.remove(temp);
                k--;
            }
        }
            //방향 결정하기
            if(list.size()==0||map[i][j]==list.size()){
                d=0;
            }
            //4개로 나누기
            if (sumM / 5 == 0) return;
            for (int l = 0; l < 4; l++) {
                fires.add(new fire(i,j,sumM/5,sumS/map[i][j],dir[d][l]));
            }

    }
}
