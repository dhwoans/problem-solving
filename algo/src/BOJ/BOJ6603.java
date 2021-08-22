package BOJ;

import java.util.Scanner;

public class BOJ6603 {
    static int r,n;
    static boolean isSelect[];
    static int input[];
    static int arr[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String data ="7 1 2 3 4 5 6 7\n" +
                "8 1 2 3 5 8 13 21 34\n" +
                "0";

        sc=new Scanner(data);
        while (true){
            n=sc.nextInt();
            if(n==0){break;}
            r=6;
            arr =new int[r];
            input= new int[n];
            isSelect=new boolean[n];
            for (int i = 0; i < input.length; i++) {
                input[i]=sc.nextInt();
            }
            dfs(0,0);
            System.out.println();

        }
    }
    static void dfs(int cnt,int start){
        if(cnt==r){
            for (int z : arr) {
                System.out.print(z+" ");
            }
            System.out.println();
            return;
        }
        for (int i=start; i < input.length; i++) {
            if(isSelect[i]) continue;
            arr[cnt]=input[i];
            isSelect[i]=true;
            dfs(cnt+1,i+1);
            isSelect[i]=false;
        }
    }
}
