package BOJ.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * @packageName : BOJ.Bronze
 * @fileName : BOJ_4806_줄세기
 * @date : 2021. 12. 10.
 * @language : JAVA
 * @classification :
 * @time_limit : 1sec
 * @required_time : 00:40 ~ 01:22
 * @submissions : 1
 * @description
 * IDE로는 테스트가 안된다.
 **/
public class BOJ4806 {
    public static void main(String[] args) throws IOException {

        int count=0;

            BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
            while(br.readLine() != null)
                count++;


        System.out.println(count);


    }
}
