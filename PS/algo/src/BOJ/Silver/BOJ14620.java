package BOJ.Silver;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14620 {

    private static int[][] map;
    private static boolean[][] visited;
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];
        answer = Integer.MAX_VALUE;

        //정보 입력
        for (int i = 0; i < map.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < map[i].length; j++) {
                map[i][j]= Integer.parseInt(st.nextToken());
            }
        }
        dfs(0,0);
        System.out.println(answer);

    }

    private static void dfs(int cnt,int sum) {
       if(cnt==3){
           answer = Math.min(answer,sum);
           return;
       }
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if(check(i,j)&&!visited[i][j]){
                    visited[i][j]=true;
                    dfs(cnt+1,sum+flower(i,j));

                    clear(i, j);
                    visited[i][j]=false;
                }
            }
        }
    }

    private static void clear(int i, int j) {
        int[][] dir={{0,1},{0,-1},{1,0},{-1,0}};
        for (int k = 0; k < 4; k++) {
            int nx = i + dir[k][0];
            int ny = j + dir[k][1];


            visited[nx][ny] = false;
        }
    }

    private static int flower(int i,int j) {
        int sum =map[i][j];
        int[][] dir={{0,1},{0,-1},{1,0},{-1,0}};
        for (int k = 0; k < 4; k++) {
            int nx = i+dir[k][0];
            int ny = j+dir[k][1];

            sum+=map[nx][ny];
            visited[nx][ny]=true;

        }
        return sum;
    }

    private static boolean check(int i,int j) {
        int[][] dir={{0,1},{0,-1},{1,0},{-1,0}};
        for (int k = 0; k < 4; k++) {
            int nx = i+dir[k][0];
            int ny = j+dir[k][1];

            if(nx<0||ny<0||nx>=map.length||ny>=map[0].length||visited[nx][ny])return false;

        }
        return true;

    }
}
