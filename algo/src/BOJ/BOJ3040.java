package BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ3040 {
    static int n,r;
    static int input[];
    static int arr[];
    static boolean isSelect[];
    static int sum;
    static StringBuilder sb= new StringBuilder();
    public static void main(String[] args) {
        String data = "7\n" +
                "8\n" +
                "10\n" +
                "13\n" +
                "15\n" +
                "19\n" +
                "20\n" +
                "23\n" +
                "25";

        Scanner sc = new Scanner(System.in);
        sc=new Scanner(data);

        n=9;
        r=7;
        input=new int[n];
        isSelect=new boolean[n];
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
                sum+=x;
            }

            if(sum==100){
                for(int x:arr){
                    System.out.println(x);
                }
                return;
            }
            sum=0;
            return;
        }
        for(;i<n;i++){
            if(isSelect[i])continue;

            arr[cnt]=input[i];
            isSelect[i]=true;
            dfs(cnt+1,i);
            isSelect[i]=false;
        }
    }
}
