package exD4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * 1246.[S/W 문제해결 응용] 4일차 - 보급로
 *
 * 다익스트라
 *
 * 2차원 배열
 */
public class Expert1249 {
    static int n;
    static int[][] map;
    static int[][] visit;
    static PriorityQueue<xxyy> pq;
    static int[][] dir ={{-1,0},{1,0},{0,-1},{0,1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            n=Integer.parseInt(br.readLine());
            map = new int[n][n];
            visit = new int[n][n];

            //값 받기
            for (int i = 0; i < map.length; i++) {
                String str= br.readLine();
                for (int j = 0; j < map.length; j++) {
                    map[i][j]= Character.getNumericValue(str.charAt(j));
                    visit[i][j]= Integer.MAX_VALUE;
                }
            }
            Dij();
            System.out.println("#"+test_case+" "+visit[n-1][n-1]);
        }

    }

    private static void Dij() {
        pq = new PriorityQueue<>();
        pq.add(new xxyy(0,0,map[0][0]));
        visit[0][0]=map[0][0];
        while (!pq.isEmpty()){
            xxyy z = pq.poll();

            if(map[z.x][z.y]>visit[z.x][z.y])continue;

            for (int i = 0; i < 4; i++) {
                int nx = z.x+dir[i][0];
                int ny = z.y+dir[i][1];

                //범위 체크
                if(nx<0||ny<0||nx>=n||ny>=n)continue;
                //갱신
                if(visit[nx][ny]>visit[z.x][z.y]+map[nx][ny]){
                    visit[nx][ny]=visit[z.x][z.y]+map[nx][ny];
                    pq.add(new xxyy(nx,ny,map[nx][ny]));
                }
            }
        }

    }
}
class xxyy implements Comparable<xxyy> {
    int x;
    int y;
    int cost;

    xxyy(int x,int y,int cost){
        this.x=x;
        this.y=y;
        this.cost=cost;
    }

    @Override
    public int compareTo(xxyy o) {
        return this.cost-o.cost;
    }
}