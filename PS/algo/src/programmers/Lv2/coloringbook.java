package programmers.Lv2;

import java.util.LinkedList;
import java.util.Queue;

public class coloringbook {

    private boolean[][] visited;

    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;


        visited = new boolean[m][n];
        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < picture[i].length; j++) {
                if(picture[i][j]!=0&&!visited[i][j]){
                    numberOfArea++;
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, bfs(i,j,picture));
                }
            }
        }
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    public int bfs(int i,int j, int[][] picture){
        int count =1;
        int[][] dir={{-1,0},{1,0},{0,-1},{0,1}};
        visited[i][j]=true;
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{i,j});

        while(!que.isEmpty()){
            int[] temp = que.poll();

            for (int k = 0; k < 4; k++) {
                int nx = temp[0]+dir[k][0];
                int ny = temp[1]+dir[k][1];

                if(nx<0||ny<0||nx>=visited.length||ny>=visited[0].length)continue;
                if(visited[nx][ny]||picture[nx][ny]!=picture[i][j])continue;
                visited[nx][ny]=true;
                que.add(new int[]{nx,ny});
                count++;
            }
        }
        return count;
    }
}
