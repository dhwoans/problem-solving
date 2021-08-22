package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1987 {
    static int R,C,max;
    static char[][] board;
    static boolean[] used;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new char[R][C];
        used = new boolean[26];
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = str.charAt(j);
            }
        }

        solve(0, 0, 1);
        System.out.println(max);
    }
    //00 초기 위치 체크.
    // 상하좌우 이동
    // 이동한 알파벳은 true 처리
    // max 이동 구하기

    private static void solve(int x, int y, int cnt) {
        if(used[board[x][y] -'A']) return;
        used[board[x][y] -'A'] = true;
        max = cnt>max? cnt:max;
        for(int k = 0; k<4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            if(nx<0 || ny<0 || nx>=R || ny >=C) continue;
            solve(nx,ny,cnt+1);
        }
        used[board[x][y] -'A'] = false;
    }
}


