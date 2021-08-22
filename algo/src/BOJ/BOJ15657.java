package BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ15657 {
    static int n,r;
    static int input[];
    static int arr[];
    static StringBuilder sb = new StringBuilder();
    
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        r=sc.nextInt();
        input=new int[n];
        arr=new int[r];

        for(int i=0;i<n;i++){
            input[i]=sc.nextInt();
        }

        Arrays.sort(input);
        dfs(0,0);
        System.out.println(sb);

    }
    static void dfs(int cnt,int i){
        if(cnt==r){
            for(int x:arr){
                sb.append(x+" ");
            }
            sb.append("\n");

            return;
        }

        for(;i<n;i++){
            arr[cnt]=input[i];
            dfs(cnt+1,i);
        }
    }
}
