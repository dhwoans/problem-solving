package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ14629 {

    private static int[][] map;
    private static int[][] dir={{0,1},{0,-1},{1,0},{-1,0}};
    private static PriorityQueue<Integer> que;

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        que = new PriorityQueue<>();
        int answer=0;

        //정보 입력
        for (int i = 0; i < map.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < map[i].length; j++) {
                map[i][j]= Integer.parseInt(st.nextToken());
            }
        }
        for (int k = 0; k < 3; k++) {
            int min = Integer.MAX_VALUE;
            for (int i = 1; i < map.length-1; i++) {
                for (int j = 1; j < map[0].length-1; j++) {
                    if(min>bfs(i,j)){

                    }
                }
            }
        }

    }

    private static int bfs(int i,int j) {
        int sum=0;
        for (int k = 0; k < 4; k++) {
            int nx = i+dir[k][0];
            int ny = j+dir[k][1];

            if(nx<0||ny<0||nx>=map.length||ny>=map[0].length)return Integer.MAX_VALUE;
            sum+=map[nx][ny];
        }
        return sum;
    }
}
