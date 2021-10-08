package SWEA.ex;

import java.util.Arrays;
import java.util.Scanner;


public class Expert1984 {
    public static void main(String[] args) {
        String data ="10\n" +
                "3 17 1 39 8 41 2 32 99 2\n" +
                "22 8 5 123 7 2 63 7 3 46\n" +
                "6 63 2 3 58 76 21 33 8 1\n" +
                "345 37 2375 23 32 132 47 76 26 12\n" +
                "765 26 346 16 263 36 61 569 35 70\n" +
                "912 923 7456 879 8237 864 1170 6893 34 9\n" +
                "934 73 456 3 47 32 74 18 23 345 \n" +
                "72 812 73 384 23 76 54 94 556 834\n" +
                "87 51 438 126 48 13 834 162 805 21\n" +
                "213 21 45 87 476 59 98 325 900 11";
        Scanner sc =new Scanner(System.in);
        sc=new Scanner(data);
        int T =sc.nextInt();

        for(int i=0;i<T;i++){
            double avg =0;
            int sum=0;
            int[] arr= new int[10];
            //배열담기
            for(int j=0;j<arr.length;j++){
                arr[j]=sc.nextInt();
            }
            //배열정렬
            Arrays.sort(arr);
            //중간값평균
            for(int z=1;z<arr.length-1;z++){

                sum+= arr[z];

            }
            avg=(double) sum/8;
            System.out.println(Math.round(avg));
        }
    }
}
