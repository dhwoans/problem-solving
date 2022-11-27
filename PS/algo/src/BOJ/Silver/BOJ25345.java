package BOJ.Silver;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ25345 {

    private static int[] arr;
    private static boolean[] visited;
    private static int[] pick;
    private static int count;
    private static int n;
    private static int m;


    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        count = 0;
        arr = new int[n];
        pick = new int[m];
        visited = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }
        
        //dfs
        dfs(0, m,0);
        System.out.println(count);
    }
    private static void dfs(int cnt,int end,int start) {
        if(cnt==end){
            cal();
            System.out.println();
            return;
        }
        for (int i = start; i < arr.length; i++) {
            if(visited[i])continue;
            visited[i]=true;
            pick[cnt]=arr[i];
            dfs(cnt+1,end,i);
            visited[i]=false;
        }
    }
    private static void cal() {
        System.out.print(Arrays.toString(pick));
//        for (int i = 1; i < pick.length-1; i++) {
//            if(pick[i-1]>=pick[i]&&pick[i+1]>=pick[i])return;
//        }
        count++;
    }
}
