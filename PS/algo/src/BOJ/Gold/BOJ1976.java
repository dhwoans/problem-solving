package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1976 {
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        parents=new int[n];
        make(n);

        //입력값 받기
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    union(i, j);
                }
            }
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] ints = new int[m];
        for (int i = 0; i < ints.length; i++) {
            int num =Integer.parseInt(st.nextToken())-1;
            ints[i]=find(num);
        }
        String s="";
        for (int i : ints) {
            if(ints[0]==i){
                s="YES";
            }else{
                s="NO";
                break;
            }
        }
        System.out.println(s);
    }

    //make
    static void make(int n) {
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
    }

    static void union(int a, int b) {
        a=find(a);
        b=find(b);

        if(a!=b){
            parents[b]=a;
        }
    }

    static int find(int a) {
        if (parents[a] == a) {
            return a;
        } else {
            return parents[a]=find(parents[a]);

        }
    }
}
