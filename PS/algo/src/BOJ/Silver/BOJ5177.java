package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @packageName : BOJ.Silver
 * @fileName : BOJ5177
 * @date : 2022-01-02
 * @language : JAVA
 * @classification :
 * @time_limit : 2sec
 * @required_time : 00:40 ~ 01:22
 * @submissions : 1
 * @description :
 **/
public class BOJ5177 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            String answer = "not equal";
            StringBuilder sb = new StringBuilder();
            String str1 = br.readLine();
            String str2 = br.readLine();

            String case1 ="(\\{|\\[)";
            String case2 ="(\\}|\\])";
            String case3 ="(,|;)";
            String case4 =" +";
            String case5 =" *\\. *";
            String case6 =" *, *";
            String case7 =" *: *";
            String case8 =" *\\( *";
            String case9 =" *\\) *";
            //대문자 취환
            str1=str1.toUpperCase();
            str2=str2.toUpperCase();
            //앞뒤공백
            str1.trim();
            str2.trim();

            str1=str1.replaceAll(case1,"(");
            str1=str1.replaceAll(case2,")");
            str1=str1.replaceAll(case3,",");
            str1=str1.replaceAll(case4," ");
            str1=str1.replaceAll(case5,".");
            str1=str1.replaceAll(case6,",");
            str1=str1.replaceAll(case7,":");
            str1=str1.replaceAll(case8,"(");
            str1=str1.replaceAll(case9,")");

            str2=str2.replaceAll(case1,"(");
            str2=str2.replaceAll(case2,")");
            str2=str2.replaceAll(case3,",");
            str2=str2.replaceAll(case4," ");
            str2=str2.replaceAll(case5,".");
            str2=str2.replaceAll(case6,",");
            str2=str2.replaceAll(case7,":");
            str2=str2.replaceAll(case8,"(");
            str2=str2.replaceAll(case9,")");

            if(str1.equals(str2)){
                answer = "equal";
            }
            System.out.println("Data Set "+ i +": "+answer);
            System.out.println();
        }
    }
}
