package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @packageName : BOJ.Silver
 * @fileName : BOJ1543
 * @date : 2022-01-01
 * @language : JAVA
 * @classification : regex
 * @time_limit : 2sec
 * @required_time : 00:40 ~ 01:22
 * @submissions : 1
 * @description :
 **/
public class BOJ1543 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Pattern pattern = Pattern.compile(br.readLine());
        Matcher matcher = pattern.matcher(str);
        System.out.println(matcher.results().count());
    }
}
