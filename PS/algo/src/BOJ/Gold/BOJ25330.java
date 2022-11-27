package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ25330 {

    private static boolean[] visited;
    private static int[] vill;
    private static int[] monster;
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        monster = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        vill = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        visited = new boolean[n];
        answer = 0;
        dfs(0,k,0,0);
        System.out.println(answer);
    }

    private static void dfs(int cnt,int k,int sum,int val) {
        if(cnt<=k){
            answer = Math.max(answer,sum);
        }else{
            return;
        }
        for (int i = 0; i < visited.length; i++) {
            if(visited[i])continue;
            visited[i]=true;
            val +=monster[i];
            dfs(cnt+val,k,sum+vill[i],val);
            val -=monster[i];
            visited[i]=false;
        }
    }
}
