package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @packageName : BOJ.Gold
 * @fileName : BOJ_2467_용액
 * @date : 2021. 12. 15.
 * @language : JAVA
 * @classification :
 * @time_limit : 1sec
 * @required_time : 00:40 ~ 01:22
 * @submissions : 1
 * @description
 **/
public class BOJ2467 {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int start = 0;
        int end = N-1;
        arr = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }

        Check(start,end);
    }

    private static void Check(int start,int end ) {
        while(start<end){


        }
    }
}
