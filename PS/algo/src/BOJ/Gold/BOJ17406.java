package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ17406 {

    private static ArrayList<round> rounds;
    private static boolean[] visited;
    private static int[] pick;
    private static int[][] copyMap;
    private static int answer;

    private static class xy {
        private int x;
        private int y;

        xy(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    private static class round {
        private int r;
        private int c;
        private int s;

        round(int r, int c, int s) {
            this.r = r;
            this.c = c;
            this.s = s;
        }
    }

    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        answer = Integer.MAX_VALUE;

        map = new int[N][M];
        //자료 입력
        for (int i = 0; i < map.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < map[0].length; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //회전연산
        rounds = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            rounds.add(new round(r - 1, c - 1, s));
        }
        //순열
        visited = new boolean[K];
        pick = new int[K];
        Permutation(0);
        System.out.println(answer);
    }

    private static void Permutation(int cnt) {
        if (cnt == rounds.size()) {
            //회전연산
            answer = Math.min(answer, Cal(pick));
            return;
        }
        for (int i = 0; i < rounds.size(); i++) {
            if (visited[i]) continue;
            visited[i] = true;
            pick[cnt] = i;
            Permutation(cnt + 1);
            visited[i] = false;
        }
    }

    private static int Cal(int[] arr) {
        //map 복사하기
        copyMap = new int[map.length][map[0].length];
        for (int i = 0; i < map.length; i++) {
            System.arraycopy(map[i], 0, copyMap[i], 0, map[0].length);
        }

        for (int j : arr) {
            //회전연산자 꺼내기
            round round = rounds.get(j);
            //회전 좌표구하기

            xy upleft = new xy(round.r - round.s, round.c - round.s);
            xy downleft = new xy(round.r + round.s, round.c - round.s);
            xy upright = new xy(round.r - round.s, round.c + round.s);
            xy downright = new xy(round.r + round.s, round.c + round.s);
            int len = round.s*2;
            while (upleft.x != downright.x && upleft.y != downright.y) {
                //배열 돌리기
                Around(upleft, downleft, upright, downright, len);
                //좌표 변경
                upleft.x += 1;
                upleft.y += 1;

                upright.x +=1;
                upright.y -=1;

                downleft.x-=1;
                downleft.y+=1;

                downright.x -= 1;
                downright.y -= 1;
                len-=2;
            }
        }
        //최소값구하기
        int min = Integer.MAX_VALUE;
        for (int[] value : copyMap) {
            int sum = 0;
            for (int ints : value) {
                sum += ints;
            }
            min = Math.min(min, sum);
        }
        return min;
    }

    private static void Around(xy upleft, xy downleft, xy upright, xy downright, int len) {
        int temp1 = copyMap[upright.x][upright.y];
        int temp2 = copyMap[downright.x][downright.y];
        int temp3 = copyMap[downleft.x][downleft.y];

        //왼쪽으로 이동
        for (int i = 0; i < len ; i++) {
            int x = upright.x;
            int y = upright.y - i;
            copyMap[x][y] = copyMap[x][y - 1];
        }
        //아래로 이동
        for (int i = 0; i < len ; i++) {
            int x = downright.x - i;
            int y = downright.y;
            if (i == len - 1)
                copyMap[x][y] = temp1;
            else
                copyMap[x][y] = copyMap[x - 1][y];
        }
        //오른쪽으로 이동
        for (int i = 0; i < len ; i++) {
            int x = downleft.x;
            int y = downleft.y+i;
            if (i == len - 1) copyMap[x][y] = temp2;
            else copyMap[x][y]=copyMap[x][y+1];
        }
        //위로이동
        for (int i = 0; i < len; i++) {
            int x = upleft.x+i;
            int y = upleft.y;
            if(i== len -1)copyMap[x][y]=temp3;
            else copyMap[x][y]=copyMap[x+1][y];
        }
    }
}
