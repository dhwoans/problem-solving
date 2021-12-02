package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * @packageName : BOJ.Silver
 * @fileName : BOJ_10989_수 정렬하기3
 * @date : 2021. 11. 29.
 * @language : JAVA
 * @classification : sort
 * @time_limit : 5sec
 * @required_time : 00:40 ~ 01:22
 * @submissions : 1
 * @description
 * counting sort
 **/
public class BOJ10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[10000001];
        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(br.readLine());
            arr[m]++;

        }
        int count =0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
           if(arr[i]>0){
               for (int j = 0; j < arr[i]; j++) {
                   sb.append(i+"\n");
                   count++;
               }
           }
           if(count==n){
               break;
           }
        }
        System.out.print(sb);
    }
}
