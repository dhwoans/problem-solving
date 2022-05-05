package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11055 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int n =Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] check = new int[n];
        //입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i]= Integer.parseInt(st.nextToken());
            check[i]=arr[i];
        }
        //DP
        for (int i = 1; i < check.length; i++) {
            for (int j = i-1; j >=0 ; j--) {
                if(arr[i]>arr[j]) {
                    check[i] = Math.max(check[i], arr[i] + check[j]);
                }
            }
        }
        int answer =0;
        for (int i : check) {
            answer = Math.max(answer,i);
        }
        System.out.println(answer);
    }
}
