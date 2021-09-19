package ex;

import java.util.Scanner;

public class Expert2047 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String T;
        T=sc.next();
        char[] arr = new char[T.length()];

        for(int i = 0; i < T.length(); i++)
        {
            arr[i]=T.charAt(i);

        }
        for(int x:arr){
            System.out.printf("%c",x-32);}
    }
}

