package SWEA.ex;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Expert1280 {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("C:\\ALGO\\algo\\src\\SWEA.ex\\input1280.txt"));
        Scanner sc = new Scanner(System.in);
        int x =10;
        for(int i=1;i<=x;i++){
            int dump = sc.nextInt();
            int answer =0;
            //배열 100
            int arr[]=new int[100];
            for(int j=0;j<arr.length;j++){
                arr[j]=sc.nextInt();
            }
            while(dump>=0){
                Arrays.sort(arr);
                answer=arr[99]-arr[0];
                arr[99]--;
                arr[0]++;
                dump--;
            }

            System.out.println("#"+i+" "+answer);
        }

    }
}
