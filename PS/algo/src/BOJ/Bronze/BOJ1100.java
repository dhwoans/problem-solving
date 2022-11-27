package BOJ.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1100 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int count =0;
        for (int i = 0; i < 8; i++) {
            String str = br.readLine();
            for (int j = 0; j < 8; j++) {
                if(i%2==1){//홀수 일때
                    if(j%2==1&&str.charAt(j)=='F'){
                        count++;
                    }
                }else{
                    if(j%2!=1&&str.charAt(j)=='F'){
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
