package BOJ.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count=1;
        int Z=N;
        while (true){
            int first = Z%10;
            int M = Z%10 + Z/10;
            int second =  M%10;
            Z=first*10+second;
            if(Z==N){
                break;
            }else{
                count++;
            }
        }
        System.out.println(count);
    }
}
