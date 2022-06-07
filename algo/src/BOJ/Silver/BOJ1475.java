package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();
        int[] arr = new int[10];
        int answer =0;
        for (int i = 0; i < num.length(); i++) {
            arr[num.charAt(i)-'0']++;
        }
        for (int i = 0; i < arr.length; i++) {
            if(i==6||i==9)continue;
            answer = Math.max(answer,arr[i]);
        }
        int temp = (arr[6]+arr[9])%2==0?arr[6]+arr[9]:arr[6]+arr[9]+1;
        System.out.println(Math.max(answer,temp/2));
    }
}
