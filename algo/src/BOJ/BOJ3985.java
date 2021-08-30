package BOJ;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ3985 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] arr = new int[T+1];
        int max1= Integer.MIN_VALUE;
        int max2 =Integer.MIN_VALUE;
        int answer1 =0;
        int answer2 =0;
        int N = Integer.parseInt(br.readLine());
        for (int j = 1; j <= N; j++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            //가장 많이 받을 거라고 예상되는 사람

            int len = end - start;
            if (len > max1) {
                if(len==max1)continue;
                max1=len;
                answer1 =j;
            }
            for (int i = start; i <= end; i++) {
                if(arr[i]==0)
                arr[i]=j;
            }
        }
            int[] count = new int[1001];
            for (int i = 0; i < arr.length; i++) {
                count[arr[i]]++;
            }

            for (int i = 1; i < count.length; i++) {
                if(count[i]>max2){
                    max2=count[i];
                    answer2=i;
                }
            }
            System.out.println(answer1);
            System.out.println(answer2);

    }
}

