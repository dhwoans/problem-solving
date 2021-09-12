package BOJ.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1075 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String str =br.readLine();
        int B = Integer.parseInt(br.readLine());
        out:for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                str=str.substring(0,str.length()-2)+i;
                str+=j;
                if(Integer.parseInt(str)%B==0){
                    System.out.printf("%d%d",i,j);
                    break out;
                }
            }

        }

    }
}
