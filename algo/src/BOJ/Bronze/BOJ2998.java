package BOJ.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2998 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String X[]  ={"000","001","010","011","100","101","110","111"};
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();

        while((str.length()+sb.length())%3!=0){
            sb.append("0");
        }
       sb.append(str);

        for (int i = 0; i < sb.length(); i+=3) {
           str=sb.substring(i,i+3);
            System.out.print(Arrays.asList(X).indexOf(str));
        }

    }
}
