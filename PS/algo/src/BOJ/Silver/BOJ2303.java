package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2303 {

    private static int[][] map;
    private static boolean[] visited;
    private static int[] pick;
    private static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer= 0;
        int answerNum =0;
        map = new int[n][5];
        for (int i = 0; i < map.length; i++) {
                map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for (int i = 0; i < map.length; i++) {
            max = 0;
            visited = new boolean[5];
            pick = new int[3];
            dfs(i,0,0);
            if(answer<=max){
                answer = max;
                answerNum = i;
            }
        }
        System.out.println(answerNum+1);
    }

    private static void dfs(int num,int cnt,int start) {
        if (cnt == 3) {
            max = Math.max(max,Arrays.stream(pick).reduce(Integer::sum).getAsInt()%10);
            return;
        }
        for (int i = start; i < map[num].length; i++) {
            if(visited[i])continue;
            visited[i]=true;
            pick[cnt]=map[num][i];
            dfs(num,cnt+1,i);
            visited[i]=false;
        }
    }
}
