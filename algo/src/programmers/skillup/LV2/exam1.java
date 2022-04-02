package programmers.skillup.LV2;







import java.util.LinkedList;


public class exam1 {
    static int[][] dir ={{-1,0},{1,0},{0,1},{0,-1}};
    static private  boolean[][] visited;


    public static int solution(int[][] maps) {
        visited = new boolean[maps.length][maps[0].length];

        return  bfs(0, 0,0,maps);

    }

    static private int bfs(int i, int j,int val,int[][] maps) {
        LinkedList<int[]> que = new LinkedList<>();
        que.add(new int[]{i,j,0});
        visited[i][j]=true;
        while (!que.isEmpty()){
            int[] z = que.poll();
            if(z[0]==maps.length-1&&z[1]==maps[0].length-1){
                return z[2];
            }

            for (int k = 0; k < 4; k++) {
                int nx = z[0]+ dir[k][0];
                int ny = z[1]+ dir[k][1];

                if(nx<0||ny<0||nx>=maps.length||ny>=maps[0].length)continue;
                if(maps[nx][ny]==1&&!visited[nx][ny]){
                    visited[nx][ny]=true;
                    que.add(new int[]{nx,ny,z[2]+1});
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}}));
    }
}