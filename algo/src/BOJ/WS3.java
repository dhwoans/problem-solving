package BOJ;

import java.util.Scanner;

public class WS3 {
    public static void main(String[] args) {
        String data="3 \n" +
                "6 \n" +
                "G B G G B B \n" +
                "G B G G B G \n" +
                "B B B B G B \n" +
                "B G B B B B \n" +
                "G B B B B G \n" +
                "G B B B B G \n" +
                "5 \n" +
                "G B G G B \n" +
                "G B G G B \n" +
                "B B B B G \n" +
                "B G B B B \n" +
                "G B B B B \n" +
                "3 \n" +
                "G G B \n" +
                "G B B \n" +
                "B B B";
        Scanner sc = new Scanner(System.in);

        sc=new Scanner(data);
        int T = sc.nextInt();
        int dir[][]={{-1,0},{1,0},{0,-1},{0,1},{-1,-1},{-1,1},{1,-1},{1,1}};//상 하 좌 우
        for(int i = 1; i<=T;i++){
            int answer =2;
            int n =sc.nextInt();
            String arr[][]=new String[n][n];
            //배열에 담기
            for(int z=0;z<n;z++){
                for(int a=0;a<n;a++){
                    arr[z][a]=sc.next();
                }
            }
            //탐색

            for(int row=0;row<n;row++){
                outer:for(int col=0;col<n;col++){
                    if(arr[row][col].equals("G")) continue;
                    //8방탐색
                    for(int z=0;z<8;z++){
                        int nr = row +dir[z][0];
                        int nc = col +dir[z][1];

                        //범위벗어남
                        if(nr<0||nc<0||nc>=n||nr>=n){
                            continue;
                        }
                        if(arr[nr][nc].equals("G")) continue outer;


                    }
                    int count =-1;

                        for(int r=0;r<n;r++){
                            if(arr[r][col].equals("B"))count++;
                            if(arr[row][r].equals("B")) count++;







                    }
                    answer=Math.max(answer,count);

                }
            }
            System.out.printf("#%d %d\n",i,answer);
        }

    }
}
