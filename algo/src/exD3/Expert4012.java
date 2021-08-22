package exD3;

import java.util.Scanner;

public class Expert4012 {
    static int[] input;
    static int[] arr;
    static boolean[] isSelect;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String data =
                "1\n" +
                "4\n" +
                "0 5 3 8\n" +
                "4 0 4 1\n" +
                "2 5 0 3\n" +
                "7 2 3 0";
        sc=new Scanner(data);
        int T =sc.nextInt();
        for (int test_case = 0; test_case < T; test_case++) {
            int n =sc.nextInt();
            int map[][] =new int[n][n];
            arr=new int[n/2];
            isSelect=new boolean[n];
            //배열 담기
            for (int r = 0; r < map.length; r++) {
                for (int c = 0; c < map.length; c++) {
                     map[r][c]= sc.nextInt();

                }

            }
            input=new int[4];
            for (int i = 0; i < n; i++) {
                input[i]=i;
            }
            pick(input,0,0,n/2);
        }
    }
    static void pick (int[] input, int cnt,int i,int r){
        if(cnt==r){
            for(int x:arr){
                System.out.print(x);
            }
            System.out.println();
            return;
        }
        for (; i < input.length; i++) {
            if(isSelect[i])continue;
            arr[cnt]=input[i];
            isSelect[i]=true;
            pick(input,cnt+1,i,r);
            isSelect[i]=false;

        }
    }

}
