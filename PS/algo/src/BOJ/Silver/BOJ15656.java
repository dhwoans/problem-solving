package BOJ.Silver;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ15656 {
    static int r,n;
    static int arr[];
    static int input[];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        r=sc.nextInt();
        input= new int[n];
        arr=new int[r];

        for(int i=0;i<input.length;i++){
            input[i]=sc.nextInt();
        }
        Arrays.sort(input);
        dfs(0);
        System.out.println(sb);

    }
    static void dfs(int cnt){
        if(cnt==r){
            for(int x:arr){
                sb.append(x+" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=0;i<n;i++){
            arr[cnt]=input[i];
            dfs(cnt+1);
        }
    }
}
