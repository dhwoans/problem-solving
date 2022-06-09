package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ12869 {

    private static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        min = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }

        dfs(arr,0);
    }

    private static void dfs(List arr,int count) {
        if(check(arr)){
            min = Math.min(count, min);
            return ;
        }
        for (int i = 0; i < arr.size(); i++) {

        }
    }
    private static boolean check(List<Integer> arr){
        for (int i : arr) {
            if(i>0)return false;
        }
        return true;
    }
}
