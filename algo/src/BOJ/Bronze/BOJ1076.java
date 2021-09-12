package BOJ.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1076 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String arr[] = {"black","brown","red","orange","yellow","green","blue","violet","grey","white"};
        int A = Arrays.asList(arr).indexOf(br.readLine());
        int B = Arrays.asList(arr).indexOf(br.readLine());
        int C = Arrays.asList(arr).indexOf(br.readLine());
       long answer = (A*10+B)*(long)(Math.pow(10,C));
        System.out.println(answer);

    }

}
