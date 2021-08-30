package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ9093 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String data ="2\n" +
                "I am happy today\n" +
                "We want to win the first prize";
        sc=new Scanner(data);
        int number= Integer.parseInt(sc.nextLine());

        String[] arr= new String[number];

        for(int i=0;i<number;i++) {
            arr[i]=sc.nextLine();
        }
        for(int i=0;i<number;i++) {
            String[] tmp = arr[i].split(" ");
            for(int j=0;j<tmp.length;j++) {
                int size = tmp[j].length()-1;
                String s2 = "";
                while(size>=0) {
                    s2 = s2+tmp[j].charAt(size--);
                }
                System.out.print(s2+" ");
            }
            System.out.println();
        }
    }
}
