package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class BOJ21758 {

    private static int[] arr;
    private static int n;
    private static int[] RtoL;
    private static int[] LtoR;

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        LtoR = new int[arr.length];
        RtoL = new int[arr.length];
        //누적합
        int sum =0;
        for (int i = 0; i < arr.length; i++) {
            sum+=arr[i];
            LtoR[i]=sum;
        }
        sum =0;
        for (int i = arr.length-1; i >= 0; i--) {
            sum+=arr[i];
            RtoL[i]=sum;
        }

        //벌통이 왼쪽
        int left =left();
        //벌통이 오른쪽
        int right = right();
        //벌통이 가운데
        int mid = mid();
        System.out.println(Math.max(mid,Math.max(left,right)));
    }

    private static int mid() {
        int max =0;
        for (int i = 1; i < arr.length-1; i++) {
            int order = LtoR[i]-arr[0];
            int reverse = RtoL[i]-arr[arr.length-1];
            max = Math.max(max,order+reverse);
        }
        return max;
    }

    private static int right() {
        int max = 0;

        for (int i = 1; i < arr.length-1 ; i++) {
            int first = LtoR[arr.length-1]-arr[i]-arr[0];
            int sec = LtoR[arr.length-1]-LtoR[i];
            max = Math.max(max,first+sec);
        }
        return max;
    }

    private static int left() {
        int max = 0;

        for (int i = arr.length-2; i > 0; i--) {
            int first = RtoL[0]-arr[i]-arr[arr.length-1];
            int sec = RtoL[0]-RtoL[i];
            max = Math.max(max,first+sec);

        }
        return max;
    }
}
