package SWEA.ex;

import java.util.Scanner;

public class Expert2050 {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        String string = sc.next();
        char[] chars = new char[string.length()];

        for (int i = 0; i < string.length(); i++) {
            chars[i]=string.charAt(i);
        }
        for(int x : chars){
            System.out.printf("%d\t",x);
        }
    }
}
