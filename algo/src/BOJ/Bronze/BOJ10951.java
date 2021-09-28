package BOJ.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10951 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input ="";
        while ((input=br.readLine())!=null) {

            StringTokenizer st = new StringTokenizer(input);
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            System.out.println(num1 + num2);
        }
    }

}
