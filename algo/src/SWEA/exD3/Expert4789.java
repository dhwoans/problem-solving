package SWEA.exD3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class Expert4789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String data ="4\n" +
                "11111\n" +
                "09\n" +
                "110011\n" +
                "1";

        br=new BufferedReader(new StringReader(data));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            String str = br.readLine();
            int count=0;
            int answer=0;
            for (int i = 0; i < str.length(); i++) {
                if(count<i){
                    answer+=i-count;
                    count=i;
                }
                count+=Character.getNumericValue(str.charAt(i));
            }
            System.out.println("#"+test_case+" "+answer);
        }
    }
}
