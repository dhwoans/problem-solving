package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1083 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        var n = Integer.parseInt(br.readLine());
        var arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        var m = Integer.parseInt(br.readLine());

        for (int i = 0; i < arr.length; i++) {
            int max = arr[i];
            for (int j = 0; j < arr.length; j++) {

            }
        }
        Arrays.stream(arr).forEach(value -> System.out.print(value+" "));
    }
}
