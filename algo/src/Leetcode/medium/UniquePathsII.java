package Leetcode.medium;



public class UniquePathsII {
    static int[][] map ;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        map= new int[obstacleGrid.length][obstacleGrid[0].length];
//        for (int i = 0; i < map.length; i++) {
//            for (int j = 0; j < map[0].length; j++) {
//                map[i][j]=-1;
//            }
//        }

        //DP와 재귀
        poo(0,0,obstacleGrid);
        return map[0][0];
    }

    private int poo(int n,int m,int[][] obstacleGrid) {
        //도착지
        if(n==obstacleGrid.length-1&&m==obstacleGrid[0].length-1&&obstacleGrid[n][m]!=1){
//            map[n][m]=0;
            map[n][m]+=1;
            return 1;
        }
        //방문 한적있다면
        if(map[n][m]!=0){
            return map[n][m];
        }else{
            if(obstacleGrid[n][m]==1)return 0;
//            map[n][m]=0;
            int[][] dir ={{0,1},{1,0}};
            for (int i = 0; i < 2; i++) {
                int nx = n+dir[i][0];
                int ny = m+dir[i][1];
                if(nx>=0&&ny>=0&&nx<obstacleGrid.length&&ny<obstacleGrid[0].length&&obstacleGrid[nx][ny]!=1){
                    map[n][m]+=poo(nx,ny,obstacleGrid);
                }
            }
        }
        return map[n][m];
    }
}
