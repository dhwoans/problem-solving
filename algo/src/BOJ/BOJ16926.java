package BOJ;

import java.util.Scanner;

public class BOJ16926 {
    public static void main(String[] args) {
        String data="4 4 2\n" +
                "1 2 3 4\n" +
                "5 6 7 8\n" +
                "9 10 11 12\n" +
                "13 14 15 16";

        Scanner sc = new Scanner(System.in);
        sc= new Scanner(data);


        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] arr = new int[N][M];
        int round =sc.nextInt();
        //배열에 넣기
        for(int r=0;r<N;r++){
            for(int c=0;c<M;c++){
                arr[r][c]=sc.nextInt();
            }
        }
        int temp= arr[0][0];
        int temp2 = arr[N-1][M-1];
        for(int i=N-1;i>1;i++){
            arr[i][0]=arr[i-1][0];
        }

        for(int j=M-1;j>0;j--){
            arr[N-1][M-1]=arr[N-2][M-2];
        }
        System.out.println(arr);
    }
}
