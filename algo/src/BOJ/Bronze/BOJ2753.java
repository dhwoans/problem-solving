package BOJ.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * 2753.윤년 */
public class BOJ2753 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int answer =0;
        int leap =  Integer.parseInt(br.readLine());
        if((leap%4==0&&leap%100!=0)||(leap%400==0)){//윤년
            answer =1;
        }
        System.out.println(answer);
    }
}
