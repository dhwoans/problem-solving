package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1783 {

    static int[][] dir={{-2,1},{-1,2},{2,1},{1,2}};
    private static int answer;
    private static int c;
    private static int r;

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        c = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        answer = 1;

        Bfs(r -1,0);
        System.out.println(answer);
    }

    private static void Bfs(int x,int y) {
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{x,y,1});

        while(!que.isEmpty()){
            int[] z = que.poll();

            answer = Math.max(answer, z[2]);
            for (int i = 0; i < 4; i++) {
                int nx = z[0]+dir[i][0];
                int ny = z[1]+dir[i][1];

                if(nx<0||ny<0||nx>=r||ny>=c)continue;
                que.add(new int[]{nx,ny,z[2]+1});
            }
        }
    }
}
