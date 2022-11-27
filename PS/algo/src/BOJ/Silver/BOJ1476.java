package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @packageName : BOJ.Silver
 * @fileName : BOJ_1476_날짜계산
 * @date : 2021. 12. 07.
 * @language : JAVA
 * @classification : math
 * @time_limit : 2sec
 * @required_time : 00:40 ~ 01:22
 * @submissions : 1
 * @description
 **/
public class BOJ1476 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        E=E==15?0:E;
        S=S==28?0:S;
        M=M==19?0:M;
        for (int i = 1; i <= 7980; i++) {
            if(i%15==E && i%28==S && i%19==M){
                System.out.println(i);
                break;
            }
        }

    }
}
