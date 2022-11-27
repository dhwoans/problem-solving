package BOJ.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @packageName : BOJ.Bronze
 * @fileName : BOJ1264
 * @date : 2021-12-30
 * @language : JAVA
 * @classification : regular expression
 * @time_limit : 2sec
 * @required_time : 00:40 ~ 01:22
 * @submissions : 1
 * @description :
 **/
public class BOJ1264 {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        while(true){
            String str = br.readLine();
            if(str.equals("#"))break;
            int count =0;
            Pattern pattern = Pattern.compile("[AEIOUaeiou]");
            Matcher matcher = pattern.matcher(str);

            sb.append(matcher.toMatchResult()+"\n");
        }
        System.out.println(sb);
    }
}
