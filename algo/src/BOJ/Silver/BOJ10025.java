package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @packageName : BOJ.Silver
 * @fileName : BOJ10025
 * @date : 2021-12-28
 * @language : JAVA
 * @classification : sliding window
 * @time_limit : 2sec
 * @required_time : 00:40 ~ 01:22
 * @submissions : 1
 * @description :
 **/
public class BOJ10025 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int start = 0;
        int sum = 0;
        int max = 0;
        int answer =0;
        int[] arr = new int[1000001];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int q =Integer.parseInt(st.nextToken());
            int index =Integer.parseInt(st.nextToken());
            arr[index]=q;
            max = Math.max(max,index);
        }

        for (int end = 0; end <= max; end++) {
            sum+=arr[end];
            if(end>= (K*2)+1){
                sum-=arr[start];
                start++;
            }
            answer = Math.max(answer,sum);
        }
        System.out.println(answer);
    }
}
