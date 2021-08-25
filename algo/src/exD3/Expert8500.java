package exD3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Expert8500 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String data = "2\n" +
                "3\n" +
                "2 3 2\n" +
                "5\n" +
                "5 2 3 1 4";
        br=new BufferedReader(new StringReader(data));
        int T  = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            int n =Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < arr.length; i++) {
                arr[i]= Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            int sum =n;
            for (int i : arr) {
                sum+=i;
            }
            sum+=arr[arr.length-1];
            System.out.println("#"+test_case+" "+sum);

        }

    }

}
