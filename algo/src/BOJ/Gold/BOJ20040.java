package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ20040 {

    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int answer = 0;
        arr = new int[n];
        make(n);
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to =Integer.parseInt(st.nextToken());
            if(find(from)!=find(to)){
                union(from,to);
            }else{
                System.out.println(i+1);
                return;
            }
        }
        System.out.println(answer);
    }

    private static void union(int a,int b) {
        a = find(a);
        b = find(b);
        if(a>b)arr[a]=b;
        else arr[b]=a;
    }

    private static int find(int a) {
        if(arr[a]==a) return a;
        return find(arr[a]);
    }

    private static void make(int n) {
        for (int i = 0; i < n; i++) {
            arr[i]=i;
        }
    }
}
