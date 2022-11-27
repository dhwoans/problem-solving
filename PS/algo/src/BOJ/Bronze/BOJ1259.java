package BOJ.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1259.팰린드롬수
 *
 * 문자열 비교
 *
 * 한자리 숫자도 팰린드롬?
 */
public class BOJ1259 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String str="";
        while(!(str=br.readLine()).equals("0")){
            String answer = "yes";
            for (int i = 0; i < str.length()/2; i++) {
                if(str.charAt(i)!=str.charAt(str.length()-1-i)){
                    answer ="no";
                    break;
                }

            }

            System.out.println(answer);
        }
    }
}
