package BOJ.Silver;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ15654 {
    static int n,r;
    static int arr[];
    static int input[];
    static boolean isSelect[];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        r=sc.nextInt();
        arr= new int[n];
        isSelect=new boolean[n+1];
        input=new int[r];
        for(int i=0;i<arr.length;i++){
            arr[i]=sc.nextInt();
        }
        Arrays.sort(arr);
        dfs(0);
        System.out.println(sb);
    }
    static void dfs(int cnt){
        if(cnt==r){
            for(int x:input){
                sb.append(x+" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=0;i<n;i++){
            if(isSelect[i+1]) continue;

            input[cnt]=arr[i];
            isSelect[i+1]=true;
            dfs(cnt+1);
            isSelect[i+1]=false;
        }
    }
}
