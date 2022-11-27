package BOJ.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2864 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int temp1 = Integer.parseInt(Integer.toString(a).replace("5","6"));
        int temp2 = Integer.parseInt(Integer.toString(a).replace("6","5"));
        int temp3 = Integer.parseInt(Integer.toString(b).replace("5","6"));
        int temp4 = Integer.parseInt(Integer.toString(b).replace("6","5"));

        int max = temp1+temp3;
        int min = temp2+temp4;

        System.out.println(min+" "+max);
    }
}
