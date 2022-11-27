package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17179 {
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        arr = new int[m + 1];
        //자를수 있는 곳
        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        arr[m]=l;

        //자르기
        for (int i = 0; i < n; i++) {
            int answer = 0;
            int cut = Integer.parseInt(br.readLine());
            //이진 탐색
            int start = 0;
            int end = arr[m];

            while(start<=end){
                int mid  = (start+end)/2;
                int count = check(mid);
                if(count>cut){
                    start = mid+1;
                    answer = Math.max(answer,mid);
                }else{
                    end = mid-1;

                }
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);

    }

    private static int check(int mid) {
        int count =0;
        int start =0;
        for (int i = 0; i < arr.length; i++) {
            if(mid<=arr[i]-start){
                count++;
                start= arr[i];
            }
        }
        return count;
    }
}
