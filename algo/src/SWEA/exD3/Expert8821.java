package SWEA.exD3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Expert8821 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
//        String data =
//                "3\n" +
//
//                "121\n" +
//
//                "0123456789\n" +
//
//                "555555";
//        br= new BufferedReader(new StringReader(data));
        int T =Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            String str = br.readLine();
            int[] ints = new int[10];
            //배열담기
            for (int i = 0; i < str.length(); i++) {

                ints[Character.getNumericValue(str.charAt(i))]++;
            }
            int count =0;
            for (int i = 0; i < ints.length; i++) {
                if(ints[i]%2!=0){
                   count++;
                }
            }
            System.out.println("#"+test_case+" "+count);
        }

    }
}
