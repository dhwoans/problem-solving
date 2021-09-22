package BOJ.Silver;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ15655 {
        static int r,n;
        static int arr[];
        static int input[];
        static boolean isSelect[];
        static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        r=sc.nextInt();
        arr=new int[n];
        input=new int[r];
        isSelect=new boolean[n];


        for(int i=0;i<arr.length;i++){
            arr[i]=sc.nextInt();
        }
        Arrays.sort(arr);
        dfs(0,0);
        System.out.println(sb);

    }
    static void dfs(int cnt,int i){
        if(cnt==r){
            for(int x:input){
                sb.append(x+" ");
            }

            sb.append("\n");
            return;
        }

        for(;i<n;i++){
            if(isSelect[i]) continue;

            input[cnt]=arr[i];
            isSelect[i]=true;
            dfs(cnt+1,i+1);
            isSelect[i]=false;
        }
    }
}
