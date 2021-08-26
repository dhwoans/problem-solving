package exD3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Expert7236 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String data ="1\n" +

                "3\n" +
                "G G W\n" +
                "G W W\n" +
                "W W W";

        br=new BufferedReader(new StringReader(data));
        int dir[][] = {{-1,0},{1,0},{0,-1},{0,1},{-1,-1},{-1,1},{1,-1},{1,1}};
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            int N= Integer.parseInt(br.readLine());
            char[][] map = new char[N][N];
            for (int r = 0; r < map.length; r++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int c = 0; c < map.length; c++) {
                    map[r][c]=st.nextToken().charAt(0);
                }
            }
            int max = Integer.MIN_VALUE;
            int depth =0;
            for (int r = 0; r < map.length; r++) {
                for (int c = 0; c < map.length; c++) {
                    if(map[r][c]=='W'){

                        //8방탐색
                        int count =0;
                        for (int i = 0; i < 8; i++) {
                            int nr = r+dir[i][0];
                            int nc = c+dir[i][1];

                            if(nr<0||nc<0||nr>=map.length||nc>=map.length) continue;
                            if(map[nr][nc]=='W') count++;

                        }
                        if(count==0){
                            depth=1;
                        }else{
                            depth=count;
                        }
                    }
                    max =Math.max(max,depth);
                    depth=0;
                }

            }
            System.out.println("#"+test_case+" "+max);
        }

    }
}
