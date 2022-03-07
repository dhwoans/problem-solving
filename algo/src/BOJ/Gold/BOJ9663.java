package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9663 {

    private static int[] map;
    private static boolean[] visited;
    private static int n;
    private static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n];

        count = 0;
        check(0);

        System.out.println(count);
    }

    private static void check(int cnt) {
        if(cnt==n){
            count++;
            return;
        }
        for (int i = 0; i < n; i++) {
            map[cnt]=i;
            if(possible(cnt)){
                check(cnt+1);
            }
        }
    }
    private static boolean possible(int cnt){
        for (int i = 0; i < cnt; i++) {
            //같은 행
            if(map[i]==map[cnt]){
                return false;
            }
            //대각선
            else if(Math.abs(map[cnt]-map[i]) == Math.abs(cnt-i)){
                return false;
            }
        }
        return true;
    }
}
