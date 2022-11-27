package SWEA.ex;

import java.util.Scanner;

public class Expert1959 {
    public static void main(String[] args) {
        String data = "10\n" +
                "3 5\n" +
                "1 5 3\n" +
                "3 6 -7 5 4\n" +
                "7 6\n" +
                "6 0 5 5 -1 1 6\n" +
                "-4 1 8 7 -9 3\n" +
                "5 15\n" +
                "-8 4 6 -9 -1\n" +
                "-1 1 0 -2 10 10 0 2 5 2 10 7 -9 7 -8\n" +
                "11 20\n" +
                "3 -8 4 0 -1 -4 8 3 7 -3 1\n" +
                "3 10 0 1 10 0 -8 -6 9 -7 -1 1 -1 4 10 6 0 -8 -5 0\n" +
                "11 16\n" +
                "-6 0 -1 7 5 -1 -3 0 -9 8 4\n" +
                "0 -6 1 1 8 -8 0 -7 4 -7 -8 -2 1 4 0 -10\n" +
                "3 16\n" +
                "8 9 0\n" +
                "-4 9 -7 -1 -8 3 1 -6 -8 5 2 -7 -9 -10 8 9\n" +
                "11 3\n" +
                "3 -4 -7 7 -2 5 5 0 -2 -8 4\n" +
                "-1 1 3\n" +
                "14 6\n" +
                "-9 9 0 -7 8 10 7 -3 2 3 0 0 0 -2\n" +
                "8 1 -9 3 0 -7\n" +
                "17 10\n" +
                "-6 -1 -4 2 -5 1 -10 -9 8 -9 -6 1 10 0 -5 -8 1\n" +
                "7 6 2 7 -8 4 8 10 -2 9\n" +
                "11 9\n" +
                "8 6 -2 0 0 5 10 2 -10 -8 -10\n" +
                "10 -9 -7 -1 0 8 0 10 3\n";

        Scanner sc = new Scanner(System.in);
        sc = new Scanner(data);
        int T = sc.nextInt();
        for(int i=0;i<T;i++){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] Lo;
            int[] sho;
            int sum =0;
            int answer =Integer.MIN_VALUE;

            //배열에 담기
            if(n<m){
                Lo =new int[m];
                sho =new int[n];
                for(int j=0;j<n;j++){
                    sho[j]=sc.nextInt();
                }
                for(int j=0;j<m;j++){
                    Lo[j]=sc.nextInt();
                }


            }else{
                Lo = new int[n];
                sho = new int[m];
                for(int j =0;j<n;j++){
                    Lo[j]=sc.nextInt();
                }
                for(int j=0;j<m;j++){
                    sho[j]=sc.nextInt();
                }



            }
                //배열 끼리 곱하기
                for(int z=0;z<=Lo.length-sho.length;z++){
                    for(int w=0;w<sho.length;w++){

                        sum+=Lo[z+w]*sho[w];
                    }

                    answer = Math.max(sum,answer);
                    sum = 0;
                }
                System.out.println(answer);


        }
    }
}
