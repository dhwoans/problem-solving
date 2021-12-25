package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;
/**
 * @packageName : BOJ.Silver
 * @fileName : BOJ_2407_조합
 * @date : 2021. 12. 07.
 * @language : JAVA
 * @classification : math
 * @time_limit : 2sec
 * @required_time : 00:40 ~ 01:22
 * @submissions : 1
 * @description
 **/
public class BOJ2407 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Integer.parseInt(st.nextToken());
        long m = Integer.parseInt(st.nextToken());
        BigInteger sum = BigInteger.ONE;

        for (long i = (n-m)+1; i <=n ; i++) {
            sum=sum.multiply(new BigInteger(String.valueOf(i)));
        }
        for (long i = 2; i <=m ; i++) {
            sum=sum.divide(new BigInteger(String.valueOf(i)));
        }
        System.out.println(sum);
    }
}
