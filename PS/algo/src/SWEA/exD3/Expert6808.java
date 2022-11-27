package SWEA.exD3;

import java.util.Scanner;

public class Expert6808 {
    static int arr1[];
    static int input[];
    static boolean isSelect[];
    static int arr2[];
    static int count;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String data = " 4\n" +
                "1 3 5 7 9 11 13 15 17\n" +
                "18 16 14 12 10 8 6 4 2\n" +
                "13 17 9 5 18 7 11 1 15\n" +
                "1 6 7 9 12 13 15 17 18";

        sc = new Scanner(data);
        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            boolean deck[] = new boolean[19];
            isSelect=new boolean[9];
            arr1 = new int[9];
            arr2 = new int[9];
            input = new int[9];
            int choice = 0;
            for (int n = 0; n < 9; n++) {
                choice = sc.nextInt();
                deck[choice] = true;
            }

            for (int i = 1,num=0,num2=0; i < deck.length; i++) {
                if(deck[i]){
                    arr1[num]=i;
                    num++;

                }else{
                    input[num2]=i;
                    num2++;
                }

            }
            dfs(0);

            System.out.println("#"+test_case+" "+count+" "+(362880-count));
            count=0;

        }

    }
    static void dfs(int cnt){
        if(cnt==9){
            int sum1=0;
            int sum2=0;
            for (int i = 0; i < arr1.length; i++) {
                if(arr1[i]>arr2[i]){
                    sum1+=arr1[i]+arr2[i];
                }else{
                    sum2+=arr1[i]+arr2[i];
                }
            }
            if(sum1>sum2){
                count++;
            }

            return;
        }
        for (int j=0; j < input.length; j++) {
            if(isSelect[j])continue;
            arr2[cnt]=input[j];
            isSelect[j]=true;
            dfs(cnt+1);
            isSelect[j]=false;
        }
    }
}


