package SWEA.ex;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Expert1979 {
    static int count;
    static int arr[][];
    static int n;
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("C:\\ALGO\\algo\\src\\input\\input_1979.txt"));
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();


        //배열담기
        for (int test_case = 1; test_case <= T; test_case++) {
            n = sc.nextInt();
            int k = sc.nextInt();

            int amount = 0;
            arr = new int[n][n];

            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    arr[r][c] = sc.nextInt();
                }
            }
            //가로 탐색
            for(int r=0;r<arr.length;r++){
                count=0;
                for(int c=0;c<arr.length;c++) {
                    if(arr[r][c]==1){
                        count++;
                        if(c+1==arr.length&&count==k){
                            amount++;

                        }
                }else if(arr[r][c]==0){
                        if(count==k){
                            amount++;
                        }
                        count=0;

                    }

                }
            }
            //세로탐색
            for(int c=0;c<arr.length;c++){
                count=0;
                for(int r=0;r<arr.length;r++) {
                    if(arr[r][c]==1){
                        count++;
                        if(r+1==arr.length&&count==k){
                            amount++;
                            count=0;
                        }
                    }else if(arr[r][c]==0){
                        if(count==k){
                            amount++;
                        }
                        count=0;
                    }
                }
            }
            System.out.printf("#%d %d\n",test_case,amount);

        }
    }

}