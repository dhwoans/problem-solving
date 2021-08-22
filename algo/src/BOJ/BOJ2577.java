package BOJ;

import java.util.Arrays;

public class BOJ2577 {
    public static void main(String[] args) {
        int a = 150;
        int b = 266;
        int c = 427;
        int value = a * b * c;

        int[] arr = new int[10];


        while (value > 0) {
            arr[value % 10]++;
            value /= 10;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }}
