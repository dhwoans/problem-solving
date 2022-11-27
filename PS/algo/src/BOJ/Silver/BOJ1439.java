package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1439 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int count1 =0;
        int count2 =0;
        int num = str.charAt(0)=='0'?1:0;
        boolean flag= true;
        for (int i = 0; i < str.length(); i++) {
            if(num!=str.charAt(i)){
                if(flag)count1++;
                else count2++;
                flag= !flag;
                num=str.charAt(i);
            }
        }
        System.out.println(Math.min(count1,count2));
    }
}
