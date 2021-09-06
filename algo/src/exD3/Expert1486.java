package exD3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Expert1486 {//풀이중
    static int N;
    static int B;
    static int[] input;
    static boolean[] isSelect;

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        input=new int[N];
        isSelect=new boolean[N];
        st=new StringTokenizer(br.readLine());
        for (int i = 0; i < input.length; i++) {
            input[i]= Integer.parseInt(br.readLine());
        }
        dfs(0,0);
    }

    static void dfs(int cnt,int sum){
        if(sum>=B){
            return;
        }
        for (int i = 0; i < N; i++) {
            if(isSelect[i])continue;
            sum+=input[i];
            isSelect[i]=true;


        }
    }

}
