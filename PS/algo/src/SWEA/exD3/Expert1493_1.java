package SWEA.exD3;

import java.util.Scanner;

public class Expert1493_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int map[][] = new int[200][200];
        int cnt =1;
        for (int i = 1; i <= 200; i++) {
            for (int j = 1; j <= i; j++) {
                map[j][i+1-j] =cnt++;
            }
        }
       int T = sc.nextInt();
        for (int test_case = 0; test_case < T; test_case++) {
            int p= sc.nextInt();
            int q= sc.nextInt();
            int a=0,b=0,c=0,d=0;
            for (int i = 0; i < 200; i++) {
                for (int j = 0; j < 200; j++) {
                    if(map[i][j]==p){
                        a=i;
                        b=j;
                    }
                    if(map[i][j]==q){
                        c=i;
                        d=j;
                    }
                }
            }
        }
    }

}
