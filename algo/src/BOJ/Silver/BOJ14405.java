package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @packageName : BOJ.Silver
 * @fileName : BOJ14405
 * @date : 2022-01-04
 * @language : JAVA
 * @classification :
 * @time_limit : 2sec
 * @required_time : 00:40 ~ 01:22
 * @submissions : 1
 * @description :
 **/
public class BOJ14405 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Pattern pattern = Pattern.compile("(pi|ka|chu)+");
        Matcher matcher = pattern.matcher(str);


        if(matcher.matches()){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
}
