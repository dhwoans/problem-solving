package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2667 {
    static int n,count;
    static ArrayList num;
    static int[][] map;
    static boolean[][] visit;
    static int[][] dir ={{-1,0},{1,0},{0,-1},{0,1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        count = 0;
        map = new int[n][n];
        visit = new boolean[n][n];
        num = new ArrayList<Integer>();
        //배열에 담기
        for (int r = 0; r < map.length; r++) {
            String str = br.readLine();
            for (int c = 0; c < map.length; c++) {
                map[r][c]=Character.getNumericValue(str.charAt(c));
            }
        }
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if(map[i][j]==1&&!visit[i][j]){
                    int[] ints = new int[2];
                    ints[0]=i;
                    ints[1]=j;
                    BFS(ints);
                }
            }
        }
        System.out.println(count);
        Collections.sort(num);
        for (Object o : num) {
            System.out.println(o);
        }
    }
    static  void BFS(int[] x){
        int danji = 0;
        Queue q  = new LinkedList<Integer[]>();
        q.offer(x);
        visit[x[0]][x[1]]=true;
        while (!q.isEmpty()){
            danji++;
            int[] s = (int[]) q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = s[0]+dir[i][0];
                int ny = s[1]+dir[i][1];

                if(nx<0||ny<0||nx>=n||ny>=n)continue;
                if(map[nx][ny]==1&&!visit[nx][ny]){
                    visit[nx][ny]=true;
                    int[] ints = new int[2];
                    ints[0]=nx;
                    ints[1]=ny;
                    q.offer(ints);
                }
            }
        }
        num.add(danji);
        count++;
    }
}
