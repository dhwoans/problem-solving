package BOJ;


import java.util.Scanner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.io.StringReader;
import java.util.StringTokenizer;

public class BOJ13458 {
    public static void main(String[] args) throws IOException {

        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String data="5\n" +
                "1 1 1 1 1\n" +
                "5 2";
        br=new BufferedReader(new StringReader(data));
        int N = Integer.parseInt(br.readLine());
        long count =0;
        count +=N;
        int[] a = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int B =Integer.parseInt(st1.nextToken());
        int C =Integer.parseInt(st1.nextToken());

        for (int i = 0; i < a.length; i++) {

            a[i]= Integer.parseInt(st.nextToken())-B;
        }
        for (int i : a) {
            if(i<0)continue;
            count+=i/C;
            i%=C;
            while(i>0){
                i-=C;
                count++;
            }
        }
        System.out.println(count);


    }
}
