package exD3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.HashSet;

public class Expert7087 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String data ="1\n" +


                "6\n" +
                "Air\n" +
                "Card\n" +
                "Dad\n" +
                "Dad\n" +
                "Ear\n" +
                "Blue\n" +
                "Ace";
        br=new BufferedReader(new StringReader(data));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            int N =Integer.parseInt(br.readLine());
            int[] word = new int[27];
            for (int i = 0; i < N; i++) {

                word[br.readLine().charAt(0)-65]++;
            }

            int count=0;
            for (int i : word) {
                if(i==0)break;
                count++;
            }

            System.out.println("#"+test_case+" "+count);
        }
    }
}
