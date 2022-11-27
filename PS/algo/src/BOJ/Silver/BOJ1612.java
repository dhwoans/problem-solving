package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1612 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int temp = 1;
        int count =1;
        if(n%5==0||n%2==0){
            System.out.println(-1);
            return;
        }
        while (temp%n!=0){
            count++;
            temp = (temp%n)*10+1;
        }
        System.out.println(count);
    }
}
