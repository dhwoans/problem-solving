package BOJ.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2748 {
    static long arr[];
    static long fibo(int n){
        if(n>=2&&arr[n]==0){
            arr[n]=fibo(n-2)+fibo(n-1);
        }
        return arr[n];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int T =Integer.parseInt(br.readLine());
        arr= new long[91];
        arr[0]=0;
        arr[1]=1;



        System.out.println(fibo(T));
    }
}
