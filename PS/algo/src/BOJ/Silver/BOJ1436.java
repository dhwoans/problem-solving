package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * @packageName : BOJ.Silver
 * @fileName : BOJ_1436_영화감독 숌
 * @date : 2021. 11. 29.
 * @language : JAVA
 * @classification : brute force
 * @time_limit : 2sec
 * @required_time : 00:40 ~ 01:22
 * @submissions : 1
 * @description
 * 숫자 구하기
 **/
public class BOJ1436 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count=1;

        for (int i = 666; i <22230667; i++) {
            String str = Integer.toString(i);
            if(str.contains("666")){
                count++;

            }
            if(count==n+1){
                System.out.println(i);
                break;
            }
        }
    }

}
