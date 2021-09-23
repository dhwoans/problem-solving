package BOJ;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2615 {//풀이중
    static int count;
    static int[][] map;
    static boolean[][] visit;
    static int[][] dir = {{0, 1}, {1, 0}, {1, 1}, {1, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new int[19][19];
        visit = new boolean[19][19];
        //배열담기
        for (int i = 1; i < map.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j < map[i].length; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //탐색
        int[] answer = new int[3];
        out:for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 1 || map[i][j] == 2) {
                    search(i, j);
                    if(count==5){
                        answer[0]=map[i][j];
                        answer[1]=i;
                        answer[2]=j;
                        break out;
                    }
                }
            }
        }
        System.out.println(answer[0]);
        if(answer[0]!=0){
            System.out.println(answer[1]+" "+answer[2]);

        }
    }

    static void search(int r, int c) {
        for (int i = 0; i < 4; i++) {
        count =0;
            int nr = r + dir[i][0];
            int nc = c + dir[i][1];

            if(nr<0||nc<0||nr>=map.length||nc>=map.length)continue;
            if(map[r][c]==map[nr][nc]){
                count++;
                while(map[nr][nc]==map[r][c]){
                    count++;
                    nr+=dir[i][0];
                    nc+=dir[i][1];
                    if(nr<0||nc<0||nr>=map.length||nc>=map.length)break;

                }
            }
            if(count==5){
                
            }
        }
    }

}

