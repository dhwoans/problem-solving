package BOJ.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @packageName : BOJ.Bronze
 * @fileName : BOJ2857
 * @date : 2021-12-31
 * @language : JAVA
 * @classification :
 * @time_limit : 2sec
 * @required_time : 00:40 ~ 01:22
 * @submissions : 1
 * @description :
 **/
public class BOJ2857 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] str = new String[5];
        ArrayList<Integer> answer = new ArrayList<>();
        //입력 담기
        for (int i = 0; i < 5; i++) {
            str[i] = br.readLine();
        }
        for (int i = 0; i <str.length; i++) {
            Pattern pattern = Pattern.compile(".*FBI.*");
            Matcher matcher = pattern.matcher(str[i]);
            if (matcher.find()){
               answer.add(i+1);
            }

        }
        if(answer.isEmpty()){
            System.out.println("HE GOT AWAY!");
        }else{
            for (Integer i : answer) {
                System.out.print(i+" ");
            }
        }
    }
}
