package BOJ.Silver;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @packageName : BOJ.Silver
 * @fileName : BOJ_1763_듣보잡
 * @date : 2021. 09. 30.
 * @language : JAVA
 * @classification : hash
 * @time_limit : 2sec
 * @required_time : 00:40 ~ 01:22
 * @submissions : 1
 * @description
 * map을 이용
 **/
public class BOJ1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N =Integer.parseInt(st.nextToken());
        int M =Integer.parseInt(st.nextToken());

        Set<String> set= new HashSet();
        StringBuilder sb = new StringBuilder();
        int count=0;
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            set.add(s);
        }

        ArrayList<String> str = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            String s1 =br.readLine();
            if(set.contains(s1)){
                count++;
               str.add(s1);
            }
        }
        Collections.sort(str);
        System.out.println(count);
        str.stream().forEach(s -> System.out.println(s));
    }
}
