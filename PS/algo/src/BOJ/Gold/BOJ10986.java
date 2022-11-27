package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ10986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        var n = Integer.parseInt(st.nextToken() );
        var m = Integer.parseInt(st.nextToken());
        var arr = Arrays.stream(br.readLine().split(" ")).map(Long::parseLong).toArray(Long[]::new);
        var prefix = new long[m];

        var sum =0;

        for (int i = 0; i < n; i++) {
            sum += arr[i]%m;
            prefix[sum%m]++;
        }
        var count =prefix[0];
        for (long j : prefix) {
            if (j > 1) count += j * (j - 1) / 2;
        }

        System.out.println(count);
    }
}
