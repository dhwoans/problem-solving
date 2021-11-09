package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 14502.연구소
 *
 * 조합
 * BFS
 */
public class BOJ14502 {
    static int[][] map;
    static ArrayList<Integer[]> arr;
    static boolean[] visit;
    static int max;
    static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};//상 하 좌 우

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        //값입력
        map=new int[N][M];
        arr = new ArrayList<>();
        for (int i = 0; i < map.length; i++) {
            st= new StringTokenizer(br.readLine());
            for (int j = 0; j < map[i].length; j++) {
                map[i][j]=Integer.parseInt(st.nextToken());
                if(map[i][j]==0){
                    arr.add(new Integer[]{i,j});
                }
            }
        }
        visit=new boolean[arr.size()];
        max=Integer.MIN_VALUE;
        comb(0);
        System.out.println(max);
    }

    private static void comb(int cnt) {
        if(cnt==3){
             cal();
             return ;
        }
        for (int i = 0; i < visit.length; i++) {
            if(visit[i])continue;
            visit[i]=true;
            comb(cnt+1);
            visit[i]=false;
        }

    }

    private static void cal(){
        //map 복사
        int[][] temp = new int[map.length][map[0].length];
        for (int i = 0; i < temp.length; i++) {
            System.arraycopy(map[i],0,temp[i],0,map[i].length);
        }
        //벽설치
        for (int i = 0; i < visit.length; i++) {
            if(visit[i]){
                temp[arr.get(i)[0]][arr.get(i)[1]]=1;
            }
        }
        //Bfs
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                if(map[i][j]==2){
                    bfs(i,j,temp);
                }
            }
            
        }
        //0세기
        int count=0;
        for (int[] ints : temp) {
            for (int i : ints) {
                if(i==0){
                    count++;
                }
            }
        }
        max=Math.max(count,max);
    }
    private static void bfs(int i,int j,int[][] map){
        Queue<Integer[]> que = new LinkedList<>();
        que.add(new Integer[]{i,j});

        while (!que.isEmpty()){
            Integer[] z= que.poll();

            for (int k = 0; k < 4; k++) {
                int nr = z[0]+dir[k][0];
                int nc = z[1]+dir[k][1];

                //범위 초과
                if(nr<0||nc<0||nr>=map.length||nc>=map[0].length)continue;
                if(map[nr][nc]==0){
                    map[nr][nc]=2;
                    que.add(new Integer[]{nr,nc});
                }


            }
        }
    }
}
