package BOJ.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BOJ2750 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int T= Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[T];
        for (int i = 0; i < T; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Set<Integer> hs = new HashSet<Integer>(Arrays.asList(arr));
        arr=hs.toArray(new Integer[0]);
        Arrays.sort(arr);
        for (Integer i : arr) {
            System.out.println(i);
        }



    }
}
