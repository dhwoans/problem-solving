package SWEA.ex;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Expert1961 {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("C:\\ALGO\\algo\\src\\input\\input1961.txt"));
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int test_case=1;test_case<=T;test_case++){
            int size = sc.nextInt();

            int[][] arr = new int[size][size];
            //배열담기
            for(int r=0;r<arr.length;r++){
                for(int c=0;c<arr.length;c++){
                    arr[r][c]=sc.nextInt();
                }
            }
            System.out.printf("#%d\n",test_case);
            for(int i=size-1;i>=0;i--){
                for(int j=size-1;j>=0;j--){
                    System.out.printf("%d",arr[j][(size-1)-i]);

                }
                    System.out.printf(" ");
                for(int j=size-1;j>=0;j--){
                    System.out.printf("%d",arr[i][j]);
                }
                    System.out.printf(" ");
                for(int j=0;j<arr.length;j++){
                    System.out.printf("%d",arr[j][i]);

                }
                System.out.println();
            }

        }


    }
}
