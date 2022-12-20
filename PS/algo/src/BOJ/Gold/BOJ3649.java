package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ3649 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        String str = null;

        while ((str = br.readLine()) != null) {
            var len = Integer.parseInt(str) * 10_000_000;
            var n = Integer.parseInt(br.readLine());
            var arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }
            Arrays.sort(arr);
            var start = 0;
            var end = n - 1;
            var flag = false;
            while (start < end) {
                if (arr[start] + arr[end] == len) {
                   flag = true;
                   break;

                } else if (arr[start] + arr[end] > len) {
                    end--;
                } else if (arr[start] + arr[end] < len) {
                    start++;
                }
            }
            if(flag) System.out.println("yes" + " " + arr[start] + " " + arr[end]);
            else System.out.println("danger");
        }
    }
}
