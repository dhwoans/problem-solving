package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Math.max;

public class BOJ2110 {

    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int answer = 0;
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int start = 1;
        int end = arr[n - 1]-arr[0]+1;

        while (start < end) {
            int mid = (start + end) / 2;
            int count = checkHouse(mid);

            if (count >= c) start = mid+1;
             else end = mid;

        }
        System.out.println(start-1);
    }

    private static int checkHouse(int mid) {
        int count =1;
        int currentHouse = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(arr[i]-currentHouse>=mid){
                currentHouse = arr[i];
                count++;
            }
        }
        return count;
    }
}
