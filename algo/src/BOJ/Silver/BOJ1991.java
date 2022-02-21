package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1991 {

    private static int[][] map;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new int[n][2];
        //노드 입력
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int temp = st.nextToken().charAt(0)-65;
            for (int j = 0; j < map[i].length; j++) {
                String node = st.nextToken();
                if (node.equals(".")) {
                    map[temp][j] = -1;
                } else {
                    map[temp][j] = node.charAt(0) - 65;
                }

            }
        }
        sb = new StringBuilder();
        pre(0);
        System.out.print(sb+"\n");
        sb = new StringBuilder();
        in(0);
        System.out.print(sb+"\n");
        sb = new StringBuilder();
        post(0);
        System.out.print(sb+"\n");

    }

    private static void post(int node) {
        if(map[node][0]!=-1)post(map[node][0]);
        if(map[node][1]!=-1)post(map[node][1]);
        sb.append(Character.toChars(node+65));
        return;
    }

    private static void in(int node) {
        if(map[node][0]!=-1)in(map[node][0]);
        sb.append(Character.toChars(node+65));
        if(map[node][1]!=-1)in(map[node][1]);
    }

    private static void pre(int node) {
        sb.append(Character.toChars(node+65));
        if(map[node][0]!=-1)pre(map[node][0]);
        if(map[node][1]!=-1)pre(map[node][1]);
    }
}
