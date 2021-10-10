package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n =Integer.parseInt(st.nextToken());
        int m =Integer.parseInt(st.nextToken());
        Map<String, String> map = new HashMap<>();
        //입력
        for (int i = 1; i <= n; i++) {
            String s= br.readLine();
            map.put(s,Integer.toString(i));
            map.put(Integer.toString(i),s);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String str= br.readLine();
            sb.append(map.get(str)).append("\n");
        }
        System.out.println(sb);
    }
}
