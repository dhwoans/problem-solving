package ex;

import java.util.Scanner;

public class Expert2005 {
    public static void main(String[] args) {
        String data="1\n" +
                "10";
        Scanner sc = new Scanner(System.in);
        sc= new Scanner(data);
        int T =sc.nextInt();
        for(int test_case=1;test_case<=T;test_case++) {
            int n =sc.nextInt();
            int[][]arr = new int[n][];
            arr[0]=new int[1];
            //배열 만들기
            for(int i=0;i<n;i++){
                arr[i]=new int[i+1];
            }
            //값 넣기
            for(int i=0;i<n;i++){
                for(int j=0;j<=i;j++){
                    if(i==j||j==0){
                        arr[i][j]=1;
                    }else{
                        arr[i][j]=arr[i-1][j]+arr[i-1][j-1];
                    }
                }
            }
            System.out.printf("#%d\n",test_case);
            for(int[] x:arr){
                for(int z:x){
                    System.out.print(z+" ");
                }
                System.out.println();
            }
        }
    }
}
