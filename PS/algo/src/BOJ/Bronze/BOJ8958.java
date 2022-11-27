package BOJ.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ8958 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int T  = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int sum=0;
            int count=0;
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                if(str.charAt(j)=='O'){
                    count++;
                    sum+=count;
                }else{
                    count=0;
                }
            }
            System.out.println(sum);
        }
    }
}
