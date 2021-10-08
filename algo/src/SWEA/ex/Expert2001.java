package SWEA.ex;

import java.util.Scanner;

public class Expert2001 {
    public static void main(String[] args) {
        String data ="1\n" +

                "6 3\n" +
                "29 21 26 9 5 8\n" +
                "21 19 8 0 21 19\n" +
                "9 24 2 11 4 24\n" +
                "19 29 1 0 21 19\n" +
                "10 29 6 18 4 3\n" +
                "29 11 15 3 3 29";

        Scanner sc = new Scanner(System.in);
        sc= new Scanner(data);
        int T =sc.nextInt();
        for(int test_case=1;test_case<=T;test_case++){
            int map =sc.nextInt();
            int size =sc.nextInt();
            int[][] arr = new int[map][map];
            //배열담기
            for(int x=0;x<arr.length;x++){
                for(int y=0;y<arr.length;y++){
                    arr[x][y]=sc.nextInt();
                }
            }

            int max=Integer.MIN_VALUE;
            //값구하기
            for(int r=0;r<arr.length-(size-1);r++){
                for(int c=0;c<arr.length-(size-1);c++){
                    int sum=0;
                    for(int x=0;x<size;x++){
                        for(int y=0;y<size;y++){
                            sum+=arr[r+x][c+y];
                        }

                    }
                    if(max<sum){
                        max=sum;
                    }
                }
            }
            System.out.println("#"+test_case+" "+max);
        }
    }
}
