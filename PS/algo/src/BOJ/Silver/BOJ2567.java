package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2567 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] map = new int[101][101];

        int T = Integer.parseInt(br.readLine());
        int[] rr = new int[T];
        int[] cc = new int[T];

        //배열에 그리기
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            rr[i] = r;
            cc[i] = c;
            for (int j = r; j < 10 + r; j++) {
                for (int k = c; k < 10 + c; k++) {
                    if (map[j][k] == 1) continue;
                    map[j][k] = 1;
                }

            }
        }
        //1이면 4방탐색 확인
        int count = 0;
        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int r = 0; r < map.length; r++) {
            for (int c = 0; c < map.length; c++) {
                if (map[r][c] == 1) {
                    for (int i = 0; i < 4; i++) {
                        int nr = r + dir[i][0];
                        int nc = c + dir[i][1];

                        if(nr>=1&&nr<=100&&nc>=1&&nc<=100 && map[nr][nc] == 0)
                            count++;
                        else if(nr<1 || nr>100 || nc<1 || nc>100)
                            count++;
                    }
                }
            }
        }

        System.out.println(count);
    }
}

