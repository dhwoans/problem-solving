package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * @packageName : BOJ.Silver
 * @fileName : BOJ_1920_수 찾기
 * @date : 2021. 12. 11.
 * @language : JAVA
 * @classification : binnary search
 * @time_limit : 1sec
 * @required_time : 00:40 ~ 01:22
 * @submissions : 1
 * @description
 * 이진탐색 직접 구현
 **/
public class BOJ1920_binnarySearch {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st= new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]= Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int que = Integer.parseInt(st.nextToken());

            int start =0;
            int end = arr.length-1;
            boolean flag = true;
            while (start<=end){
              int idx = (start+end)/2;


              if(arr[idx]==que){
                  sb.append(1+"\n");
                  flag=false;
                  break;
              }else if(arr[idx]<que){
                  start = idx+1;
              }else if(arr[idx]>que){
                  end =idx-1;
              }


            }
            if(flag){
                sb.append(0+"\n");
            }

        }
        System.out.println(sb);
    }
}
