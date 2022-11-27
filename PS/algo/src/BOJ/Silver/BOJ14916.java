package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ14916 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int n =Integer.parseInt(br.readLine());
        int count =0;
        while(n>0){
            if(n%5!=0){
                n-=2;
                count++;
            }else{
                n-=5;
                count++;
            }
        }
        System.out.println(n<0?-1:count);
    }
}
