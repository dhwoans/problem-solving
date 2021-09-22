package BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ15663 {//풀이중
    static int n,r;
    static int arr[];
    static int input[];
    static boolean isSelect[];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        r=sc.nextInt();
        arr = new int[r];
        input= new int[n];
        isSelect =new boolean[n];

        for(int i=0;i<n;i++){
            input[i]=sc.nextInt();
        }
        Arrays.sort(input);
        dfs(0,0);
        System.out.println(sb);

    }
    static void dfs(int cnt,int num){
        if(cnt==r){
           for(int i=0;i<arr.length;i++){


              sb.append(arr[i]+" ");
           }
           sb.append("\n");
            return;
        }

           for(int i=0;i<n;i++){
               if(num==input[i]){isSelect[i]=true;}

               arr[cnt]=input[i];
               isSelect[i]=true;
               dfs(cnt+1,arr[cnt]);
               isSelect[i]=false;
           }
        }
    }
