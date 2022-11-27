package Leetcode.medium;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class MinimumKnightMoves {
    public int minKnightMoves(int x, int y) {
        int[][] dir = {{-2,1},{-2,-1},{1,2},{1,-2},{2,1},{2,-1},{-1,2},{-1,-2}};
        int step  =0;
        boolean[][] visited = new boolean[601][601];
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{0,0,0});

        while (!que.isEmpty()){
            int[] z = que.poll();

            visited[z[0]+300][z[1]+300]=true;

            if(z[0]==x&&z[1]==y){
                return z[2];
            }
            for (int i = 0; i < 8; i++) {
                int nx = z[0]+dir[i][0];
                int ny = z[1]+dir[i][1];
                if(nx<-300||ny<-300||nx>=300||ny>=300)continue;

                int checkx= 300+nx;
                int checky= 300+ny;

                if(visited[checkx][checky])continue;
                que.add(new int[]{nx,ny,z[2]+1});
            }
            step++;
        }
        return step;
    }
}