package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class BOJ2212 {

    private static int top;
    private static List<Integer> arr;
    private static boolean[] booleans;

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        top = Integer.parseInt(br.readLine());
        arr = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }
        arr = arr.stream().distinct().collect(Collectors.toList());
        booleans = new boolean[arr.size() - 1];
        Dfs(0);


    }

    private static void Dfs(int cnt) {
        if(cnt==top-1){
            //집중국 세우기
            build();
            return;

        }
        for (int i = 0; i < booleans.length ; i++) {
            if(booleans[i])continue;
            booleans[i]=true;
            Dfs(cnt+1);
            booleans[i]=false;
        }
    }

    private static void build() {
       //자르기

    }
}
