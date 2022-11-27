package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * @packageName : BOJ.Sliver
 * @fileName : BOJ_1049_기타줄
 * @date : 2021. 12. 05.
 * @language : JAVA
 * @classification : math
 * @time_limit : 2sec
 * @required_time : 00:40 ~ 01:22
 * @submissions : 1
 * @description
 *
 **/
public class BOJ1049 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());


        int minPack = Integer.MAX_VALUE;
        int minUnit = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            minPack= Math.min(minPack,Integer.parseInt(st.nextToken()));
            minUnit= Math.min(minUnit,Integer.parseInt(st.nextToken()));

        }
        //낱개로만 사는경우
        int allUnit = n*minUnit;
        //묶음+낱개로 사는경우


        int mix = (n/6*minPack)+(n%6*minUnit);

        //묶음으로만 사는경우
        int allPack =(n/6+1)*minPack;

        int answer=Math.min(allPack,mix);
        answer=Math.min(answer,allUnit);
        System.out.println(answer);


    }
}
