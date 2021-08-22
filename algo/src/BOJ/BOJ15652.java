package BOJ;

import java.util.Scanner;

public class BOJ15652 {
    static int r,n;
    static int arr[];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n= sc.nextInt();
        r= sc.nextInt();
        arr= new int[r];

        permutation(0,1);
        System.out.println(sb);

    }
    static void permutation(int cnt,int i){
        if(cnt==r){
            for(int x:arr){
                sb.append(x+" ");
            }
            sb.append("\n");
            return;
        }

        for(;i<=n;i++){
            arr[cnt]=i;
            permutation(cnt+1,i);
        }
    }
}
