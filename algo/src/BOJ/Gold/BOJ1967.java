package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * @packageName : BOJ.Gold
 * @fileName : BOJ4970
 * @date : 2022-01-05
 * @language : JAVA
 * @classification :
 * @time_limit : 2sec
 * @required_time : 00:40 ~ 01:22
 * @submissions : 1
 * @description :
 * 플로이드 mle
 **/
public class BOJ1967 {

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<node>> arr = new ArrayList<>();

        for (int i = 0; i < n+1; i++) {
            arr.add(new ArrayList<>());
        }

        for (int i = 0; i < n+1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());

            arr.get(from).add(new node(to,len));
            arr.get(to).add(new node(from,len));
        }

        bfs();
    }

    private static void bfs() {

    }
}
