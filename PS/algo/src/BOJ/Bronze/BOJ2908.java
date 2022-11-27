package BOJ.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2908 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String temp1 = st.nextToken();
        String temp2 = st.nextToken();

        StringBuilder sb = new StringBuilder();
        sb.append(temp1).reverse();
        int num = Integer.parseInt(sb.toString());
        sb.setLength(0);
        sb.append(temp2).reverse();
        int num2 =Integer.parseInt(sb.toString());
        num = Math.max(num,num2);
        System.out.println(num);



    }
}
