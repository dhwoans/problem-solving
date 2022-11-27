package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @packageName : BOJ.Silver
 * @fileName : BOJ5637
 * @date : 2022-01-03
 * @language : JAVA
 * @classification : regex
 * @time_limit : 2sec
 * @required_time : 00:40 ~ 01:22
 * @submissions : 1
 * @description :
 **/
public class BOJ5637 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str="";
        int max = Integer.MIN_VALUE;
        String answer = "";
        out: while(true){
            str= br.readLine();
            str= str.replaceAll("[^ a-zA-Z-]{1,}","");
            StringTokenizer st = new StringTokenizer(str);
            while (st.hasMoreTokens()){
                String word = st.nextToken();
                if(word.equals("E-N-D")){
                    break out;
                }else{
                        if(max<word.length()){
                            answer =word.toLowerCase();
                            max=word.length();
                        }

                }

            }
        }
        System.out.println(answer);

    }
}
