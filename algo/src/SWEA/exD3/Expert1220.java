package SWEA.exD3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.util.Scanner;

public class Expert1220 {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("C:\\ALGO\\algo\\src\\input\\input1220.txt"));
        Scanner sc = new Scanner(System.in);

        for(int test_case=1;test_case<=10;test_case++){
            int count =0;
            int size = sc.nextInt();
            int[][] arr = new int[size][size];
            //배열넣기
            for(int r=0;r<arr.length;r++){
                for(int c=0;c<arr.length;c++){
                    arr[r][c]=sc.nextInt();
                }
            }

            for(int c=0;c<arr.length;c++){
                for(int r=0;r<arr.length;r++) {
                    if(arr[r][c]==1){
                        for(int nr=r+1;nr<arr.length;nr++){
                            if(arr[nr][c]==2){
                                count++;
                                break;
                            }
                            if(arr[nr][c]==1){
                                break;
                            }

                        }
                    }

                }
        }
            System.out.printf("#%d %d\n",test_case,count);
    }

    }
}
