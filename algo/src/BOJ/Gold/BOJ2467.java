package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2467 {
    static int[] arr;
    private static int sum;
    private static int point1;
    private static int point2;

    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int start = 0;
        int end = N-1;
        point1 = 0;
        point2 = 0;
        sum = Integer.MAX_VALUE;
        arr = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }
        Check(start,end);
        System.out.println(arr[point1]+" "+arr[point2]);

    }

    private static void Check(int start,int end ) {
        while(start<end){
            if (Math.abs(arr[start] + arr[end])<sum) {
                point1 = start;
                point2 = end;
                sum = Math.abs(arr[start] + arr[end]);
            }
            if(arr[start] + arr[end]<0){
                start++;
            }else{
                end--;
            }

        }
    }
}
