package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @packageName : BOJ.Silver
 * @fileName : BOJ3613
 * @date : 2022-01-01
 * @language : JAVA
 * @classification :
 * @time_limit : 2sec
 * @required_time : 00:40 ~ 01:22
 * @submissions : 1
 * @description :
 **/
public class BOJ3613 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();             //단어
        int[] wolf = new int[4];              //w,o,l,f
        boolean flag = false;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i)=='w'){wolf[0]++;}
            if(str.charAt(i)=='o'){wolf[1]++;}
            if(str.charAt(i)=='l'){wolf[2]++;}
            if(str.charAt(i)=='f'){wolf[3]++;}
        }
        for (int i : wolf) {
            if(i!=wolf[0]){
               break;
            }
        }
        Pattern pattern = Pattern.compile("wolf");
        Matcher matcher = pattern.matcher(str);
        if(matcher.matches()){
            System.out.println(1);
        }else{
            System.out.println(0);
        }
    }
}
