package SWEA.exD3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Expert7985 {
    static Queue<Integer> que;
    static int[] arr;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String data = "1\n" +
                "4\n" +
                "0 1 2 3 4 5 6 7 8 9 10 11 12 13 14";

        br= new BufferedReader(new StringReader(data));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            que = new LinkedList<>();
            sb= new StringBuilder();
            int len =(int) (Math.pow(2, N)) - 1;
            arr = new int[len];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < arr.length; i++) {
                arr[i]=Integer.parseInt(st.nextToken());
            }
           que.offer(arr[len/2]);

            int cnt =N;
            cnt--;

            tree(len/2,cnt);

            System.out.print("#"+test_case+" ");
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= (int)(Math.pow(2,i-1)) ; j++) {
                    System.out.print(que.poll()+" ");
                }
                System.out.println();
            }

        }

    }
    static void tree(int center,int n ){
        if(n==0){
            return;
        }
        que.offer(arr[center-(int)(Math.pow(2,n-1))]);
        
        que.offer(arr[center+(int)(Math.pow(2,n-1))]);
        
        tree(center-(int)(Math.pow(2,n-1)),n-1);
        tree(center+(int)(Math.pow(2,n-1)),n-1);
        
    }
}
