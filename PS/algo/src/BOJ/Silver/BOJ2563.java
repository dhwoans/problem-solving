package BOJ.Silver;


import java.util.Scanner;

public class BOJ2563 {
    public static void main(String[] args) {
        String data = "3\n" +
                "3 7\n" +
                "15 7\n" +
                "5 2";

        Scanner sc = new Scanner(System.in);
        sc=new Scanner(data);
        int count=0;
        int[][] arr = new int[100][100];
        int T =sc.nextInt();

        for(int test_case=0;test_case<T;test_case++){
            int r=sc.nextInt();
            int c=sc.nextInt();

            for(int i=r;i<r+10;i++){
                for(int j=c;j<c+10;j++){
                    if(arr[i][j]==0){
                        arr[i][j]=1;
                        count++;
                    }

                }
            }
        }
            System.out.println(count);


    }

}
