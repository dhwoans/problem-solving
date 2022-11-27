package Leetcode.hard;

import java.util.LinkedList;

public class ShortestPathinaGridwithObstaclesElimination {
    public boolean[][][] visited;
    public int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};

    public int shortestPath(int[][] grid, int k) {
        int r = grid.length;
        int c = grid[0].length;
        visited = new boolean[k+1][r][c];
        visited[k][0][0]=true;
        LinkedList<int[]> que = new LinkedList<>();
        que.add(new int[]{k,0,0,0}); //k, x , y , count
        while(!que.isEmpty()){
            int n = que.size();
            for (int a = 0; a < n; a++) {

            }
            int[] z = que.poll();

            if(z[1]==r-1&&z[2]==c-1){
                return z[3];
            }

            for (int i = 0; i < 4 ; i++) {
                int nx = z[1] + dir[i][0];
                int ny = z[2] + dir[i][1];

                //범위에 벗어나면
                if(nx<0||ny<0||nx>=r||ny>=c)continue;
                //벽이면
                if(grid[nx][ny]==1&&z[0]>0&&!visited[z[0]-1][nx][ny]) {
                    visited[z[0]-1][nx][ny]=true;
                    que.add(new int[]{z[0] - 1, nx, ny, z[3] + 1});
                }else if(grid[nx][ny]==0&&!visited[z[0]][nx][ny]) {
                    visited[z[0]][nx][ny]=true;
                    que.add(new int[]{z[0],nx,ny,z[3]+1});
                }

            }
        }
        return -1;
    }
}
